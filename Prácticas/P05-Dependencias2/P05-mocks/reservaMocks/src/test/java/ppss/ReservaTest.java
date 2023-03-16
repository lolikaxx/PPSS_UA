package ppss;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ppss.excepciones.ReservaException;

import static org.junit.jupiter.api.Assertions.*;


public class ReservaTest {

    @Test
    void ReservaC1(){
        //Creamos el control
        IMocksControl ctrl = EasyMock.createStrictControl();

        //Hacemos el mock parcial de nuestra clase para testear
        Reserva reservaTestable =  EasyMock.partialMockBuilder(Reserva.class).addMockedMethod("compruebaPermisos").mock("ctrl");
        //Hacemos el mock de nuestra clase Factoria
        FactoriaBOs factoriaBOsMock = ctrl.mock(FactoriaBOs.class);
        //Hacemos el mock de la clase operacion
        IOperacionBO operacionMock = ctrl.mock(IOperacionBO.class);

        reservaTestable.setFactoria(factoriaBOsMock);

        //Definimos las entradas y salidas esperadas
        String login = "xxxx";
        String password = "xxxx";
        String IdenSocio = "Pepe";
        String[] isbns = {"33333"};
        String mensajeEsperado = "ERROR de permisos; ";

        //Programamos las secuencias que se deben de seguir
        EasyMock.expect(reservaTestable.compruebaPermisos(login,password,Usuario.BIBLIOTECARIO)).andReturn(false);
        ctrl.replay();
        ReservaException exceptionObtenida = assertThrows(ReservaException.class, ()-> reservaTestable.realizaReserva(login,password,IdenSocio,isbns));
        assertEquals(mensajeEsperado, exceptionObtenida.getMessage());
        ctrl.verify();

    }

    @Test
    void ReservaC2(){
        //Creamos el control
        IMocksControl ctrl = EasyMock.createStrictControl();

        //Hacemos el mock parcial de nuestra clase para testear
        Reserva reservaTestable =  EasyMock.partialMockBuilder(Reserva.class).addMockedMethod("compruebaPermisos").mock("ctrl");
        //Hacemos el mock de nuestra clase Factoria
        FactoriaBOs factoriaBOsMock = ctrl.mock(FactoriaBOs.class);
        //Hacemos el mock de la clase operacion
        IOperacionBO operacionMock = ctrl.mock(IOperacionBO.class);

        reservaTestable.setFactoria(factoriaBOsMock);

        //Definimos las entradas y salidas esperadas
        String login = "ppss";
        String password = "ppss";
        String IdenSocio = "Pepe";
        String[] isbns = {"22222","33333"};

        //Programamos las secuencias que se deben de seguir
        assertDoesNotThrow(()->EasyMock.expect(reservaTestable.compruebaPermisos(login,password,Usuario.BIBLIOTECARIO)).andReturn(true));
        EasyMock.expect(factoriaBOsMock.getOperacionBO()).andReturn(operacionMock);

        //Opcion 1
        assertDoesNotThrow(()-> operacionMock.operacionReserva(IdenSocio, isbns[0]));
        EasyMock.expectLastCall().andVoid();
        assertDoesNotThrow(()-> operacionMock.operacionReserva(IdenSocio, isbns[1]));
        EasyMock.expectLastCall().andVoid();

        //Opcion 2 Con bucle
        /**
        for (String isbn: isbns){
            Assertions.assertDoesNotThrow(
                    ()->operacionMock.operacionReserva(IdenSocio, isbn)
            );
        }
         **/
        //Opcion 3
        Assertions.assertDoesNotThrow(()->{
            operacionMock.operacionReserva(IdenSocio,isbns[0]);
            operacionMock.operacionReserva(IdenSocio,isbns[1]);
        });
        ctrl.replay();
        assertDoesNotThrow(()-> reservaTestable.realizaReserva(login,password,IdenSocio,isbns));

        ctrl.verify();
    }

    void ReservaC3(){
        //Creamos el control
        IMocksControl ctrl = EasyMock.createStrictControl();

        //Hacemos el mock parcial de nuestra clase para testear
        Reserva reservaTestable =  EasyMock.partialMockBuilder(Reserva.class).addMockedMethod("compruebaPermisos").mock("ctrl");
        //Hacemos el mock de nuestra clase Factoria
        FactoriaBOs factoriaBOsMock = ctrl.mock(FactoriaBOs.class);
        //Hacemos el mock de la clase operacion
        IOperacionBO operacionMock = ctrl.mock(IOperacionBO.class);

        //Definimos las entradas y salidas esperadas
        String login = "xxxx";
        String password = "xxxx";
        String IdenSocio = "Pepe";
        String[] isbns = {"33333"};


    }

    void ReservaC4(){
        //Creamos el control
        IMocksControl ctrl = EasyMock.createStrictControl();

        //Hacemos el mock parcial de nuestra clase para testear
        Reserva reservaTestable =  EasyMock.partialMockBuilder(Reserva.class).addMockedMethod("compruebaPermisos").mock("ctrl");
        //Hacemos el mock de nuestra clase Factoria
        FactoriaBOs factoriaBOsMock = ctrl.mock(FactoriaBOs.class);
        //Hacemos el mock de la clase operacion
        IOperacionBO operacionMock = ctrl.mock(IOperacionBO.class);

        //Definimos las entradas y salidas esperadas
        String login = "xxxx";
        String password = "xxxx";
        String IdenSocio = "Pepe";
        String[] isbns = {"33333"};


    }

    void ReservaC5(){
        //Creamos el control
        IMocksControl ctrl = EasyMock.createStrictControl();

        //Hacemos el mock parcial de nuestra clase para testear
        Reserva reservaTestable =  EasyMock.partialMockBuilder(Reserva.class).addMockedMethod("compruebaPermisos").mock("ctrl");
        //Hacemos el mock de nuestra clase Factoria
        FactoriaBOs factoriaBOsMock = ctrl.mock(FactoriaBOs.class);
        //Hacemos el mock de la clase operacion
        IOperacionBO operacionMock = ctrl.mock(IOperacionBO.class);

        //Definimos las entradas y salidas esperadas
        String login = "xxxx";
        String password = "xxxx";
        String IdenSocio = "Pepe";
        String[] isbns = {"33333"};


    }

}
