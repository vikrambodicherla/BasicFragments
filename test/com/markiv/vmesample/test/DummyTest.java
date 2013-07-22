package com.markiv.vmesample.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Activity;

import com.markiv.vme.DetailsActivity;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class DummyTest {
	@Test
	public void test() throws Exception{
		Activity activity = new DetailsActivity();
		assertNotNull(activity);
	}
}
