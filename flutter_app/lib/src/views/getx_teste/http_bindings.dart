import 'package:get/get.dart';
import 'package:smart_energy_app/src/repository/i_timeseries_repository.dart';
import 'package:smart_energy_app/src/views/getx_teste/http_controller.dart';
import 'package:smart_energy_app/src/views/getx_teste/repository/timeseries_repository.dart';

class HttpBindings implements Bindings {
  @override
  void dependencies() {
    Get.put<ITimeseriesRepository>(TimeseriesRepository());
    Get.put(HttpController(Get.find()));
  }
}
