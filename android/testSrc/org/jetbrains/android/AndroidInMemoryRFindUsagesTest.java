/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jetbrains.android;

/**
 * This class tests an alternate method of supporting resources by removing the generated R source file
 * and introducing an in memory top level class registered as a PsiElementFinder.
 */
public class AndroidInMemoryRFindUsagesTest extends AndroidFindUsagesTest {
  private AndroidInMemoryRUtil myRUtil = null;

  @Override
  protected void setupR() {
    myRUtil = new AndroidInMemoryRUtil(myFacet);
    myRUtil.setup();
  }

  @Override
  public void tearDown() throws Exception {
    try {
      myRUtil.tearDown();
    }
    finally {
      super.tearDown();
    }
  }
}
