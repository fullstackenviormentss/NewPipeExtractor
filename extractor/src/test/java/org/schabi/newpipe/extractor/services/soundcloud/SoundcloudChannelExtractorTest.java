package org.schabi.newpipe.extractor.services.soundcloud;

import org.junit.BeforeClass;
import org.junit.Test;
import org.schabi.newpipe.Downloader;
import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.channel.ChannelExtractor;
import org.schabi.newpipe.extractor.services.BaseChannelExtractorTest;

import static org.junit.Assert.*;
import static org.schabi.newpipe.extractor.ExtractorAsserts.assertEmpty;
import static org.schabi.newpipe.extractor.ExtractorAsserts.assertIsSecureUrl;
import static org.schabi.newpipe.extractor.ServiceList.SoundCloud;
import static org.schabi.newpipe.extractor.services.DefaultTests.*;

/**
 * Test for {@link SoundcloudChannelExtractor}
 */
public class SoundcloudChannelExtractorTest {
    public static class LilUzi implements BaseChannelExtractorTest {
        private static SoundcloudChannelExtractor extractor;

        @BeforeClass
        public static void setUp() throws Exception {
            NewPipe.init(Downloader.getInstance());
            extractor = (SoundcloudChannelExtractor) SoundCloud
                    .getChannelExtractor("http://soundcloud.com/liluzivert/sets");
            extractor.fetchPage();
        }

        /*//////////////////////////////////////////////////////////////////////////
        // Extractor
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testServiceId() {
            assertEquals(SoundCloud.getServiceId(), extractor.getServiceId());
        }

        @Test
        public void testName() {
            assertEquals("LIL UZI VERT", extractor.getName());
        }

        @Test
        public void testId() {
            assertEquals("10494998", extractor.getId());
        }

        @Test
        public void testCleanUrl() {
            assertEquals("https://soundcloud.com/liluzivert", extractor.getCleanUrl());
        }

        @Test
        public void testOriginalUrl() {
            assertEquals("http://soundcloud.com/liluzivert/sets", extractor.getOriginalUrl());
        }

        /*//////////////////////////////////////////////////////////////////////////
        // ListExtractor
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testRelatedItems() throws Exception {
            defaultTestRelatedItems(extractor, SoundCloud.getServiceId());
        }

        @Test
        public void testMoreRelatedItems() throws Exception {
            defaultTestMoreItems(extractor, SoundCloud.getServiceId());
        }

        /*//////////////////////////////////////////////////////////////////////////
        // ChannelExtractor
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testDescription() {
            assertNotNull(extractor.getDescription());
        }

        @Test
        public void testAvatarUrl() {
            assertIsSecureUrl(extractor.getAvatarUrl());
        }

        @Test
        public void testBannerUrl() {
            assertIsSecureUrl(extractor.getBannerUrl());
        }

        @Test
        public void testFeedUrl() {
            assertEmpty(extractor.getFeedUrl());
        }

        @Test
        public void testSubscriberCount() {
            assertTrue("Wrong subscriber count", extractor.getSubscriberCount() >= 1e6);
        }
    }

    public static class DubMatix implements BaseChannelExtractorTest {
        private static SoundcloudChannelExtractor extractor;

        @BeforeClass
        public static void setUp() throws Exception {
            NewPipe.init(Downloader.getInstance());
            extractor = (SoundcloudChannelExtractor) SoundCloud
                    .getChannelExtractor("https://soundcloud.com/dubmatix");
            extractor.fetchPage();
        }

        /*//////////////////////////////////////////////////////////////////////////
        // Additional Testing
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testGetPageInNewExtractor() throws Exception {
            final ChannelExtractor newExtractor = SoundCloud.getChannelExtractor(extractor.getCleanUrl());
            defaultTestGetPageInNewExtractor(extractor, newExtractor, SoundCloud.getServiceId());
        }

        /*//////////////////////////////////////////////////////////////////////////
        // Extractor
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testServiceId() {
            assertEquals(SoundCloud.getServiceId(), extractor.getServiceId());
        }

        @Test
        public void testName() {
            assertEquals("dubmatix", extractor.getName());
        }

        @Test
        public void testId() {
            assertEquals("542134", extractor.getId());
        }

        @Test
        public void testCleanUrl() {
            assertEquals("https://soundcloud.com/dubmatix", extractor.getCleanUrl());
        }

        @Test
        public void testOriginalUrl() {
            assertEquals("https://soundcloud.com/dubmatix", extractor.getOriginalUrl());
        }

        /*//////////////////////////////////////////////////////////////////////////
        // ListExtractor
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testRelatedItems() throws Exception {
            defaultTestRelatedItems(extractor, SoundCloud.getServiceId());
        }

        @Test
        public void testMoreRelatedItems() throws Exception {
            defaultTestMoreItems(extractor, SoundCloud.getServiceId());
        }

        /*//////////////////////////////////////////////////////////////////////////
        // ChannelExtractor
        //////////////////////////////////////////////////////////////////////////*/

        @Test
        public void testDescription() {
            assertNotNull(extractor.getDescription());
        }

        @Test
        public void testAvatarUrl() {
            assertIsSecureUrl(extractor.getAvatarUrl());
        }

        @Test
        public void testBannerUrl() {
            assertIsSecureUrl(extractor.getBannerUrl());
        }

        @Test
        public void testFeedUrl() {
            assertEmpty(extractor.getFeedUrl());
        }

        @Test
        public void testSubscriberCount() {
            assertTrue("Wrong subscriber count", extractor.getSubscriberCount() >= 2e6);
        }
    }
}
