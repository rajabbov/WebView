# WebView

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?logo=kotlin&logoColor=white) ![Android](https://img.shields.io/badge/Android-3DDC84?logo=android&logoColor=white) ![minSdk 24](https://img.shields.io/badge/minSdk_24-555)

Despite the name, this is not a single WebView demo — it is a **workbook of 20+ mini-apps**, each living in its own package and teaching one Android concept. It started as a WebView exercise and kept growing through a whole course: lists, dialogs, fragments, SQLite, ViewPager, a fairy-tale reader and a full Instagram-style navigation shell.

With 74 Kotlin classes and 64 layouts, it is the widest-ranging project here.

## Features

- **WebView** — loads a site with JavaScript enabled and in-app navigation through `WebViewClient`
- **Contacts book on SQLite** — `SQLiteOpenHelper` + a `MyDbManager` DAO with insert / fetch / update / delete
- **Swipe-to-delete & drag-to-reorder** in RecyclerView with a custom `ItemTouchHelper.SimpleCallback`
- **Fairy-tale reader** (`hikoya`) — a list of Uzbek tales (*Til va Yurak*, *Tulki va Chumoli*, …) opening into a reading screen
- **Instagram clone shell** — Home, Search, Add, Reels and Profile screens behind a bottom navigation bar
- **Fragment communication** through an interface callback (`FirstFragmentInterface`)
- **Dialogs** — alert, single-choice radio and a fully custom dialog
- **ViewPager / ViewPager2**, NavigationView drawer, Spinner, Date & Time pickers, ProgressBar on a worker thread
- **Galleries** in ListView, RecyclerView list and RecyclerView grid form

## How it works

Each package is a self-contained example, so you can open one folder and read a complete idea without jumping around the codebase:

| Package | Concept |
|---|---|
| `contact` | SQLite CRUD with a helper + manager split |
| `delete` | `ItemTouchHelper` — swipe left/right to delete, drag up/down to move |
| `fragment2` | Fragment → Activity communication through an interface |
| `instagram`, `button` | Bottom navigation hosting several fragments |
| `hikoya`, `list`, `picture` | Lists of models with custom adapters and detail screens |
| `pager`, `viewpager` | Swipeable pages with custom pager adapters |
| `dialog` | Every common dialog type side by side |
| `spiner`, `data` | Spinner, DatePicker and TimePicker input |

To try a different example, change the launcher `<activity>` in `AndroidManifest.xml`.

## Project structure

```
com.example.webview
├── ListViewActivity.kt
├── MainActivity.kt
├── MainActivity1.kt
├── ProgressBarActivity.kt
├── button/  (6)  AddFragment, BottomNavigation, HomeFragment, SearchFragment …
├── calculator/  (1)  MainActivity
├── contact/  (5)  ContactAdapter, ContactModel, MainActivity, MyDbManager …
├── data/  (2)  DataPickerActivity, TimePickerActivity
├── delete/  (4)  MainActivity, MyCustomAdapter, MyTouchHelper, RecyclerViewListener
├── dialog/  (5)  AlertDialogActivity, DialogActivity, MainActivity, MyCustomDialog …
├── fragment/  (3)  FirstFragment, FragmentActivity, SecondFragment
├── fragment2/  (4)  BlankFragment, BlankFragment2, FirstFragmentInterface, FragmentActivity
├── galerey/  (4)  GalleryAdapter, GalleryImageActivity, GalleryModel, MainActivity
├── hikoya/  (3)  HikoyaActivity, HikoyaModel, ListActivity
├── instagram/  (6)  InstagramAdd, InstagramHome, InstagramNavigation, InstagramProfile …
├── list/  (4)  CustomAdapter, FruitImageActivity, FruitModel, ListActivity
├── navigation/  (1)  NavigationViewActivity
├── pager/  (4)  CustomPagerAdapter, ModelData, Pager, PagerFragment
├── picture/  (4)  CelebrityAdapter, CelebrityImageActivity, CelebrityModel, PictureActivity
├── recyclar/  (3)  MainActivity, Model, MyCustomAdapter
├── recyclerGrid/  (4)  GalleryActivity, GalleryAdapter, ImageViewActivity, RecyclerViewListener
├── spiner/  (2)  LoginActivity, SpinerActivity
└── viewpager/  (3)  CustomViewPagerAdapter, MainActivity, SimpleFragment
```

<sub>72 source files · 1,892 lines of code · 64 layouts</sub>

## Tech stack

| | |
|---|---|
| **Language** | Kotlin |
| **UI** | XML layouts, View Binding |
| **Min / Target SDK** | 24 / 34 |
| **Navigation component** | Screen navigation |

## Getting started

```bash
git clone https://github.com/rajabbov/WebView.git
```

1. Open the folder in **Android Studio** (Ladybug or newer).
2. Let Gradle sync.
3. Run the `app` configuration on a device or emulator.

## Known limitations

- Only one activity can be the launcher at a time — switch it in the manifest to explore other examples.

---

Made by **Ibrohimjon Rajabboyev** · [@rajabbov](https://github.com/rajabbov)
