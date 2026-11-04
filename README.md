# Lab 9: JaCoCo

Нэр: Ч.Оюумаа

Код: B232270133

```
openjdk version "27" 2026-09-15
OpenJDK Runtime Environment Homebrew (build 27)
OpenJDK 64-Bit Server VM Homebrew (build 27, mixed mode, sharing)
```

```
Apache Maven 3.9.16 (2bdd9fddda4b155ebf8000e807eb73fd829a51d5)
Maven home: /opt/homebrew/Cellar/maven/3.9.16/libexec
Java version: 27, vendor: Homebrew, runtime: /opt/homebrew/Cellar/openjdk/27/libexec/openjdk.jdk/Contents/Home
Default locale: en_MN, platform encoding: UTF-8
OS name: "mac os x", version: "26.1", arch: "aarch64", family: "mac"
```

## Хэсэг A: Happy-path тест ба эхний хэмжилт

5 happy-path тестээр хэмжсэн хамралт (results/jacoco-A.csv):
- Branch: 22 / 41 = 53.7% (BRANCH_COVERED 22, BRANCH_MISSED 19)
- Line: 16 / 25 = 64.0% (LINE_COVERED 16, LINE_MISSED 9)
- Tests run: 5 (results/mvn-verify-A.txt)

Улаан мөрүүд нь голдуу алдааны замууд (IllegalArgumentException шидэх мөрүүд) болон happy-path тестэд ороогүй дүнгүүд (letterGrade-ийн C, D, F, gpa-ийн switch-ийн C, D, default салаа, scholarship-ийн сахилгын зөрчил ба 0 буцаах замууд) байна.
Шар ромботой мөрүүд нь `||` болон `&&` нөхцөлтэй if-үүд бөгөөд нөхцөл тус бүрийн зөвхөн нэг утга (үнэн эсвэл худал) шалгагдсан тул салаа хагас дутуу хамрагдсан.
