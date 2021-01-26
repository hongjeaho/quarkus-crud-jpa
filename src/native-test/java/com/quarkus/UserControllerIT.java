package com.quarkus;

import com.quarkus.controller.UserControllerTest;
import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class UserControllerIT extends UserControllerTest {

    // Execute the same tests but in native mode.
}
