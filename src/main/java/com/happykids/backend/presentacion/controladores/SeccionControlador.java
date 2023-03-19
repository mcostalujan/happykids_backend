package com.happykids.backend.presentacion.controladores;

public class SeccionControlador {

    //    public static final String SECCION_DELETED_SUCCESSFULLY = "Seccion eliminado exitosamente";
//    private iServicioSeccion ServicioSeccion;
//
///*@Resource(name = "utilityServiceV1")*/
///*private UtilityService utilityService;*/
//
//@Autowired
//public SeccionControlador(iServicioSeccion iServicioSeccion /*, UtilityService utilityService */) {
//    this.ServicioSeccion = servicioSeccion;
//    /*this.utilityService = utilityService;*/
//}
///*
//@GetMapping("/list")
//public ResponseEntity<List<Seccion>> getAllSeccion() {
//    List<Seccion> secciones = ServicioSeccion.getSecciones();
//    return new ResponseEntity<>(secciones, OK);
//}
//@GetMapping("/find/{Seccion}")
//public ResponseEntity<Seccion>getUser(@PathVariable("Seccion") Long seccion); return null
//{
//    Seccion seccion = ServicioSeccion.findSeccionById(seccion);
//    return new ResponseEntity<>(seccion, OK);
//}*/
///*
//@PostMapping("/addSeccion")
//public ResponseEntity<Seccion> register(@RequestBody Seccion seccion)return null
//{
//    Seccion newSeccion = ServicioSeccion.register(seccion.getNombre());
//	return new ResponseEntity<>(newSeccion, OK);
//}
//*/
///*
//@PostMapping("/add")
//public ResponseEntity<Seccion>
//addNewSeccion
//(
//@RequestParam("nombre") String nombre,
//@RequestParam("idUser")String idUser
//)
//return null
//{
//    Seccion newSeccion = ServicioSeccion.addNewSeccion(null);
//    return new ResponseEntity<>(newSeccion, OK);
//}
//
//@PostMapping("/update")
//public ResponseEntity<Seccion> update(@RequestParam("currentNombre") String currentNombre, @RequestParam("nombre") String nombre, @RequestParam("idUser")String idUser)
//{
//    Seccion updatedSeccion = iServicioSeccion.updateSeccion(currentNombre, nombre,idUser);
//        return new ResponseEntity<>(updatedSeccion, OK);
//}
//
//
//	@DeleteMapping("/delete/{nombre}")
//    public ResponseEntity<HttpResponse> deleteCurso(@PathVariable("nombre") String nombre) throws UtilityException {
//        cursoService.deleteCurso(nombre);
//        return response(OK, CURSO_DELETED_SUCCESSFULLY);
//    }
//	/*
//	private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
//        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
//                message), httpStatus);
//    }*/
//
//    */
///*
// *     private PieDataset buildPiePopCursosDataset() {
//        final DefaultPieDataset pieDataset = new DefaultPieDataset();
//        this.cursoService.getCursos()
//                .forEach((curso) -> pieDataset.setValue(curso.getNombre(),
//                        curso.getPorcentajePopularidad()));
//
//        return pieDataset;
//    }
//
//    private void writeChartAsPNGImage(final JFreeChart chart, final int width, final int height,
//                                      HttpServletResponse response) throws IOException {
//        final BufferedImage bufferedImage = chart.createBufferedImage(width, height);
//        response.setContentType(MediaType.IMAGE_PNG_VALUE);
//        ChartUtils.writeBufferedImageAsPNG(response.getOutputStream(), bufferedImage);
//    }
//
// */
//

}
