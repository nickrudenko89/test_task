package Controllers;

import Entities.RequestEntity;
import Entities.UserEntity;
import Forms.RequestForm;
import Services.RequestService;
import Services.UserService;
import Utils.CookieUtil;
import Utils.RedirectHelper;
import Validators.NewRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RequestsController {
    @Autowired
    private UserService userService;
    @Autowired
    private RequestService requestService;
    @Autowired
    private RedirectHelper redirectHelper;
    @Autowired
    private NewRequestValidator newRequestValidator;

    @RequestMapping("/requests")
    public String showRequests(HttpServletRequest request, Model model) {
        Cookie cookie = CookieUtil.getUserCookie(request);
        UserEntity user = userService.getLoggedUser(Integer.valueOf(cookie.getValue()));
        model.addAttribute("user", user);
        if (user.getUserType() == 1) {
            model.addAttribute("acceptedRequests", requestService.getRequestCountByStatus(1));
            model.addAttribute("declinedRequests", requestService.getRequestCountByStatus(0));
            model.addAttribute("allRequests", requestService.getAllRequests());
        } else {
            model.addAttribute("requestForm", new RequestEntity());
            model.addAttribute("displayForm", "none");
            model.addAttribute("allRequests", user.getRequests());
        }
        model.addAttribute("path", "/resources/imported_html/requests.jsp");
        return "/index";
    }

    @RequestMapping("/changeRequest")
    public String changeRequest(@RequestParam(name = "id", required = false, defaultValue = "0") int requestId,
                                @RequestParam(name = "status", required = false, defaultValue = "-1") int status,
                                HttpServletRequest request, HttpServletResponse response, Model model) {
        requestService.saveChangesToRequest(requestService.getRequestById(requestId), status);
        redirectHelper.RedirectToPage("/requests", request, response, model);
        return "/index";
    }

    @RequestMapping("/addRequest")
    public String addRequest(HttpServletRequest request, HttpServletResponse response, Model model, RequestForm requestForm, BindingResult result) {
        Cookie cookie = CookieUtil.getUserCookie(request);
        UserEntity user = userService.getLoggedUser(Integer.valueOf(cookie.getValue()));
        requestForm.setUser(user);
        newRequestValidator.validate(requestForm, result);
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("displayForm", "block");
            model.addAttribute("allRequests", user.getRequests());
            model.addAttribute("path", "/resources/imported_html/requests.jsp");
            return "/index";
        }
        requestService.saveRequest(requestForm);
        redirectHelper.RedirectToPage("/requests", request, response, model);
        return "/index";
    }
}
