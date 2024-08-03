import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
// 通过class运行测试用例
//@SelectClasses({JunitTest.class, JunitTest1.class})
// 通过包运行测试用例
@SelectPackages(value = {"tests"})
public class RunTests {
}