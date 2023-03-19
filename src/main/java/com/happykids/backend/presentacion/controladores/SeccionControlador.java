package com.happykids.backend.presentacion.controladores;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.happykids.backend.aplicacion.iServicios.iServicioSeccion;
import com.happykids.backend.dominio.entidades.Seccion;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/Seccion")
public class SeccionControlador {
    public static final String SECCION_DELETED_SUCCESSFULLY = "Seccion eliminado exitosamente";
    private iServicioSeccion ServicioSeccion;
    
/*@Resource(name = "utilityServiceV1")*/
/*private UtilityService utilityService;*/

@Autowired
public SeccionControlador(iServicioSeccion servicioSeccion /*, UtilityService utilityService */) {
    this.ServicioSeccion = servicioSeccion;
    /*this.utilityService = utilityService;*/
}
@GetMapping("/list")
public ResponseEntity<List<Seccion>> getAllSeccion() {
    List<Seccion> secciones = ServicioSeccion.getSecciones();
    return new ResponseEntity<>(secciones, OK);
}
@GetMapping("/find/{Seccion}")
public ResponseEntity<Seccion>getUser(@PathVariable("Seccion") Long seccion); return null
{
    Seccion seccion = ServicioSeccion.findSeccionById(seccion);
    return new ResponseEntity<>(seccion, OK);
}
/* 
@PostMapping("/addSeccion")
public ResponseEntity<Seccion> register(@RequestBody Seccion seccion)return null 
{
    Seccion newSeccion = ServicioSeccion.register(seccion.getNombre());
	return new ResponseEntity<>(newSeccion, OK);
}
*/
	
@PostMapping("/add")
public ResponseEntity<Seccion> 
addNewSeccion
(
@RequestParam("nombre") String nombre,
@RequestParam("idUser")String idUser
)
return null
{
    Seccion newSeccion = ServicioSeccion.addNewSeccion(null);
    return new ResponseEntity<>(newSeccion, OK);
}
	
@PostMapping("/update")
public ResponseEntity<Seccion> update(@RequestParam("currentNombre") String currentNombre, @RequestParam("nombre") String nombre, @RequestParam("idUser")String idUser)
{
    Seccion updatedSeccion = iServicioSeccion.updateSeccion(currentNombre, nombre,idUser);
        return new ResponseEntity<>(updatedSeccion, OK);
}
	
	
	@DeleteMapping("/delete/{nombre}")
    public ResponseEntity<HttpResponse> deleteCurso(@PathVariable("nombre") String nombre) throws UtilityException {
        cursoService.deleteCurso(nombre);
        return response(OK, CURSO_DELETED_SUCCESSFULLY);
    }
	/* 
	private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
                message), httpStatus);
    }*/


/*
 *     private PieDataset buildPiePopCursosDataset() {
        final DefaultPieDataset pieDataset = new DefaultPieDataset();
        this.cursoService.getCursos()
                .forEach((curso) -> pieDataset.setValue(curso.getNombre(),
                        curso.getPorcentajePopularidad()));

        return pieDataset;
    }

    private void writeChartAsPNGImage(final JFreeChart chart, final int width, final int height,
                                      HttpServletResponse response) throws IOException {
        final BufferedImage bufferedImage = chart.createBufferedImage(width, height);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        ChartUtils.writeBufferedImageAsPNG(response.getOutputStream(), bufferedImage);
    }

 */

}
