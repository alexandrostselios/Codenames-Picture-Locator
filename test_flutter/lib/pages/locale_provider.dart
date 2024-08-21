import 'package:flutter/material.dart';

class LocaleProvider with ChangeNotifier {
  Locale _locale = const Locale('el', '');

  Locale get locale => _locale;

  void setLocale(Locale locale) {
    if (locale == _locale) return;
    _locale = locale;
    print("Locale changed to: ${locale.toString()}"); // Debug print
    notifyListeners(); // Notify listeners about the locale change
  }
}
