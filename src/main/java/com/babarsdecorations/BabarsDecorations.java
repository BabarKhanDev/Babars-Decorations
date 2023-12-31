package com.babarsdecorations;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BabarsDecorations implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("babars-decorations");

	@Override
	public void onInitialize() {
		try {
			ModBlocks.registerModBlocks();
		}
		catch (Throwable ex) {
			LOGGER.error(ex.toString());
		}
	}
}