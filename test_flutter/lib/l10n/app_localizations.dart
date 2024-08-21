import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:intl/intl.dart';
import '../generated/intl/messages_all.dart';
// import 'intl/messages_all.dart';

class AppLocalizations {
  AppLocalizations(this.locale);

  final Locale locale;

  static AppLocalizations? of(BuildContext context) {
    return Localizations.of<AppLocalizations>(context, AppLocalizations);
  }

  static const LocalizationsDelegate<AppLocalizations> delegate = _AppLocalizationsDelegate();

  static Future<AppLocalizations> load(Locale locale) {
    final String name = locale.countryCode?.isEmpty ?? true
        ? locale.languageCode
        : '${locale.languageCode}_${locale.countryCode}';
    final localeName = Intl.canonicalizedLocale(name);
    return initializeMessages(localeName).then((_) {
      return AppLocalizations(locale);
    });
  }

  String get New {
    return Intl.message(
      'New',
      name: 'New',
      desc: 'The label for the New menu item',
      locale: locale.toString(),
    );
  }

  String get Save {
    return Intl.message(
      'Save',
      name: 'Save',
      desc: 'The label for the Save menu item',
      locale: locale.toString(),
    );
  }

  String get Help {
    return Intl.message(
      'Help',
      name: 'Help',
      desc: 'The label for the Help menu item',
      locale: locale.toString(),
    );
  }

  String get About {
    return Intl.message(
      'About',
      name: 'About',
      desc: 'The label for the About menu item',
      locale: locale.toString(),
    );
  }

  String get Language {
    return Intl.message(
      'language',
      name: 'Language',
      desc: 'The label for the Language menu item',
      locale: locale.toString(),
    );
  }

  String get selectLanguage {
    return Intl.message(
      'SelectLanguage',
      name: 'selectLanguage',
      desc: 'The label for the Select Language menu item',
      locale: locale.toString(),
    );
  }

  String get english {
    return Intl.message(
      'English',
      name: 'english',
      desc: 'The label for the English menu item',
      locale: locale.toString(),
    );
  }

  String get greek {
    return Intl.message(
      'Greek',
      name: 'greek',
      desc: 'The label for the Greek menu item',
      locale: locale.toString(),
    );
  }

  String get totalScore {
    return Intl.message(
      'Total Score',
      name: 'totalScore',
      desc: 'The label for the Total Score menu item',
      locale: locale.toString(),
    );
  }

  String get submit {
    return Intl.message(
      'Submit',
      name: 'submit',
      desc: 'The label for the Submit menu item',
      locale: locale.toString(),
    );
  }

  String get team1 {
    return Intl.message(
      'Team 1',
      name: 'team1',
      desc: 'The label for the Team 1 menu item',
      locale: locale.toString(),
    );
  }

  String get team1Score {
    return Intl.message(
      'Team 1 Score',
      name: 'team1Score',
      desc: 'The label for the Team 1 Score menu item',
      locale: locale.toString(),
    );
  }

  String get team2 {
    return Intl.message(
      'Team 2',
      name: 'team2',
      desc: 'The label for the team2 menu item',
      locale: locale.toString(),
    );
  }

  String get team2Score {
    return Intl.message(
      'Team 2 Score',
      name: 'team2Score',
      desc: 'The label for the Team 2 Score menu item',
      locale: locale.toString(),
    );
  }

  String get player1 {
    return Intl.message(
      'Player 1',
      name: 'player1',
      desc: 'The label for the Player 1 Score menu item',
      locale: locale.toString(),
    );
  }

  String get player2 {
    return Intl.message(
      'Player 2',
      name: 'player2',
      desc: 'The label for the Player 2 Score menu item',
      locale: locale.toString(),
    );
  }

  String get player3 {
    return Intl.message(
      'Player 3',
      name: 'player3',
      desc: 'The label for the Player 3 Score menu item',
      locale: locale.toString(),
    );
  }

  String get player4 {
    return Intl.message(
      'Player 4',
      name: 'player4',
      desc: 'The label for the Player 4 Score menu item',
      locale: locale.toString(),
    );
  }

// Add other localizable strings here
}

class _AppLocalizationsDelegate extends LocalizationsDelegate<AppLocalizations> {
  const _AppLocalizationsDelegate();

  @override
  bool isSupported(Locale locale) => ['en', 'el'].contains(locale.languageCode);

  @override
  Future<AppLocalizations> load(Locale locale) => AppLocalizations.load(locale);

  @override
  bool shouldReload(covariant LocalizationsDelegate<AppLocalizations> old) => false;
}