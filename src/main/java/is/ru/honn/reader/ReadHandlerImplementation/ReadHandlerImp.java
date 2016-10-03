package is.ru.honn.reader.ReadHandlerImplementation;

import is.ru.honn.domain.User;
import is.ru.honn.domain.Video;
import is.ru.honn.reader.Exceptions.ReaderException;
import is.ru.honn.reader.Factories.ReaderFactory;
import is.ru.honn.reader.ReadHandler;
import is.ru.honn.reader.Reader;
import is.ru.honn.service.Exceptions.ServiceException;
import is.ru.honn.service.ServiceFactories.ServiceStubFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Maggi on 28/09/16.
 */
public class ReadHandlerImp implements ReadHandler {

    ReaderFactory factory = new ReaderFactory();
    ServiceStubFactory serviceStubFactory = new ServiceStubFactory();

    public void read(int count, Object object, String readerType) {


        if(readerType.equals("videoReader") || readerType.equals("userReader")) {

            Reader reader = factory.getReader(readerType);

            List<Object> result = new ArrayList<>();
            reader.setReadHandler(this);
            try {
                result = (ArrayList) reader.read();
            } catch (ReaderException e) {
                e.printStackTrace();
            }

            try {
                if(readerType.equals("userReader")) {
                    for(Object o :  result) {
                        serviceStubFactory.getUserServiceStub().addUser( (User) o);
                    }
                } else if(readerType.equals("videoReader")) {
                    for(Object o : result) {
                        //VEIT EKKI HVAÐ Á AÐ GERA VARÐANDI USER ID HÉR
                        serviceStubFactory.getVideoServiceStub().addVideo((Video) o, 0);
                    }
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String args[]){

    }
}

