import workshoplib.Library

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("test library") {
    assertEquals(Library.threeTimes("abc"), "abcabcabc")
  }
}
