import 'package:flutter_test/flutter_test.dart';
import 'package:smart_energy_app/src/models/time_series_model.dart';
import 'package:smart_energy_app/src/views/getx_teste/repository/timeseries_repository.dart';

void main() {
  test('testing time series API repository ...', () async {
    final api = TimeseriesRepository();
    final response = await api.listall();

    for (TimeSeriesModel model in response) {
      print(model.toJson());
    }

    expect(response.isEmpty, false);
  });
}
