package Services;

import Daos.RequestDao;
import Entities.RequestEntity;
import Forms.RequestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class RequestService {
    @Autowired
    private RequestDao requestDao;

    public List<RequestEntity> getAllRequests() {
        return requestDao.getAll();
    }

    public RequestEntity getRequestById(int id) {
        return requestDao.getRequestById(id);
    }

    public int getRequestCountByStatus(int status) {
        return requestDao.getRequestCountByStatus(status);
    }

    public void saveChangesToRequest(RequestEntity request, int status) {
        request.setIsCompleted(status);
        requestDao.update(request);
    }

    public void saveRequest(RequestForm requestForm) {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setRequest(requestForm.getRequest());
        requestEntity.setBid(requestForm.getBid());
        requestEntity.setIsCompleted(requestForm.getIsCompleted());
        requestEntity.setUser(requestForm.getUser());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            requestEntity.setDueDate(dateFormat.parse(requestForm.getDueDate()));
        } catch (ParseException e) {
        }
        requestDao.save(requestEntity);
    }

}
