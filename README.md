# jpn-mynumber

日本国内で配布されるマイナンバーをチェックデジットで確認することができます。

mavenセントラルリポジトリに公開済みです。

```
<dependency>
    <groupId>org.mixer2</groupId>
    <artifactId>jpn-mynumber</artifactId>
    <version>1.0.1</version>
</dependency>
```

## 使い方

個人番号(12桁), 法人番号(13桁)を与えると、末尾のチェックデジットを計算して、番号が正しいかどうかをbooleanで返します。

```
// 法人番号の場合
boolean result = MyNumberUtil.verifyCorporationNumber("6010001008845")
// 個人番号（いわゆるマイナンバー）の場合
boolean result = MyNumberUtil.verifyMyNumber("123456789018");
```