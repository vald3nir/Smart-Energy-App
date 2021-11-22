import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:smart_energy_app/src/models/time_series_model.dart';
import 'package:smart_energy_app/src/repository/i_timeseries_repository.dart';

class TimeseriesRepository extends ITimeseriesRepository {
  final String baseURL =
      "https://python-smart-energy.herokuapp.com//consumption/";

  @override
  Future<List<TimeSeriesModel>> listall() async {
    final url =
        Uri.parse(baseURL + "daily/?date=2021-10-11&user_name=Valdenir");

    print(url);
    final response = await http.get(url);
    final List<dynamic> responseMap = jsonDecode(response.body);
    return responseMap
        .map<TimeSeriesModel>((resp) => TimeSeriesModel.fromMap(resp))
        .toList();
  }
}
