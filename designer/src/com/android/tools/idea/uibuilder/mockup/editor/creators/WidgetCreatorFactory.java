/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.android.tools.idea.uibuilder.mockup.editor.creators;

import com.android.SdkConstants;
import com.android.tools.idea.uibuilder.mockup.Mockup;
import com.android.tools.idea.uibuilder.model.NlModel;
import com.android.tools.idea.uibuilder.surface.ScreenView;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

/**
 * Handles the creation of the widgets and layouts from a mockup
 */
public final class WidgetCreatorFactory {


  @NotNull
  public static WidgetCreator create(@NotNull String widgetClassName,
                                     @NotNull Mockup mockup,
                                     @NotNull NlModel model,
                                     @NotNull ScreenView screenView,
                                     @NotNull Rectangle bounds) {
    @NotNull final WidgetCreator creator;
    switch (widgetClassName) {
      case SdkConstants.VIEW_INCLUDE:
        creator = new IncludeTagCreator(mockup, model, screenView, bounds);
        break;
      case SdkConstants.IMAGE_VIEW:
        creator = new ImageViewCreator(mockup, model, screenView, bounds);
        break;
      default:
        creator = new SimpleViewCreator(mockup, model, screenView, bounds);
    }
    return creator;
  }
}
