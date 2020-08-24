package test;

import com.macro.mall.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author oliver
 */
@Api(tags = "TestController", description = "测试")
@Controller
@RequestMapping("/")
public class TestController {


    @ApiOperation("测试")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult test() {
        return CommonResult.success(null,"test okay");
    }
}
