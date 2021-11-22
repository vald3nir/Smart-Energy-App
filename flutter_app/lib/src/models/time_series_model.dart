import 'dart:convert';

class TimeSeriesModel {
  String date;
  double consumptionKwh;

  TimeSeriesModel({
    required this.date,
    required this.consumptionKwh,
  });

  Map<String, dynamic> toMap() {
    return {
      'date': date,
      'consumptionKwh': consumptionKwh,
    };
  }

  factory TimeSeriesModel.fromMap(Map<String, dynamic> map) {
    return TimeSeriesModel(
      date: map['date'],
      consumptionKwh: map['consumption_kwh'],
    );
  }

  String toJson() => json.encode(toMap());

  factory TimeSeriesModel.fromJson(String source) =>
      TimeSeriesModel.fromMap(json.decode(source));
}
