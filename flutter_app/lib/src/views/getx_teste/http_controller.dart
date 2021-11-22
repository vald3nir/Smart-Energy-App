import 'package:get/get.dart';
import 'package:smart_energy_app/src/repository/i_timeseries_repository.dart';

class HttpController extends GetxController with StateMixin {
  final ITimeseriesRepository timeseriesRepository;

  HttpController(this.timeseriesRepository);

  @override
  void onInit() {
    super.onInit();
    findtimeseries();
  }

  Future<void> findtimeseries() async {
    change([], status: RxStatus.loading());
    try {
      
      final response = await timeseriesRepository.listall();
      print(response);
      change(response, status: RxStatus.success());
   
    } catch (e) {
      print(e);
      change([], status: RxStatus.error(e.toString()));
    }
  }
}
