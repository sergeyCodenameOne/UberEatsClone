/**
 * Licensed to Codename One LTD under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Codename One licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


package com.codename1.demos.grub;

import com.codename1.l10n.L10NManager;
import com.codename1.ui.CN;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;

import static com.codename1.ui.util.Resources.getGlobalResources;

public class Util {
    private static Image roundRectImage = null;

    public static String getPriceAsString(double price){
        String priceString =  price + "";
        if (priceString.indexOf('.') + 2 <= priceString.length() - 1){
            priceString = priceString.substring(0, priceString.indexOf('.') + 2);
        }
        return priceString + "0 " + L10NManager.getInstance().getCurrencySymbol();
    }

    public static Object createRoundMask(int size){
        Image maskImage = Image.createImage(size, size);
        Graphics g = maskImage.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0x000000);
        g.fillRect(0, 0, size, size);
        g.setColor(0xffffff);
        g.fillArc(0, 0, size, size, 0, 360);
        return maskImage.createMask();
    }

    public static Object createRoundRectangleMask(int width, int height){
        if (roundRectImage == null){
            roundRectImage = getGlobalResources().getImage("round-rectangle.png");
        }

        return roundRectImage.scaled(width, height).createMask();
    }

    public static Object createHalfRoundRectangleMask(int width, int height){
        if (roundRectImage == null){
            roundRectImage = getGlobalResources().getImage("half-round-rectangle.png");
        }

        return roundRectImage.scaled(width, height).createMask();
    }

    public static float convertToDips(int pixels){
        final int pixelsPerDip = CN.convertToPixels(1);
        return pixels / pixelsPerDip;
    }

}
