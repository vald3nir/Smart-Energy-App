import 'package:smart_energy_app/src/models/time_series_model.dart';

abstract class ITimeseriesRepository {
  Future<List<TimeSeriesModel>> listall();
}
