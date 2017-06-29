package com.example.dellc.newsclienttest.bean;

import java.util.List;

/**
 * Created by yls on 2017/6/29.
 */

public class VideoEntity {

    /**
     * sizeSHD : 0
     * replyCount : 0
     * videosource : 新媒体
     * mp4Hd_url : null
     * title : 哈士奇吃了主人给的柠檬，直接急眼了
     * cover : http://vimg3.ws.126.net/image/snapshot/2017/6/O/C/VCN62K2OC.jpg
     * videoTopic : {"alias":"每日更新狗狗搞笑视频，文章。","tname":"狗狗在哪里","ename":"T1492061880479","tid":"T1492061880479","topic_icons":"http://dingyue.nosdn.127.net/wDFxCuouZtCwq7cjZHll7Aoque=1PVWYJyH4IB3Spzxh91492061879579.jpg"}
     * description : 哈士奇吃了主人给的柠檬，直接急眼了
     * replyid : BN5R28N1050835RB
     * length : 39
     * m3u8_url : http://flv.bn.netease.com/videolib3/1706/29/DVagA8984/SD/movie_index.m3u8
     * vid : VBN5R28N1
     * topicName : 狗狗在哪里
     * votecount : 0
     * topicImg : http://vimg1.ws.126.net/image/snapshot/2017/4/L/N/VCH4ERCLN.jpg
     * topicDesc : 分享各类狗狗视频、图片、总会有那么一条二货会二到你，也总会有一条会萌翻你！
     * topicSid : VCH4ERCKU
     * replyBoard : video_bbs
     * playCount : 0
     * sectiontitle :
     * mp4_url : http://flv2.bn.netease.com/videolib3/1706/29/DVagA8984/SD/DVagA8984-mobile.mp4
     * playersize : 1
     * sizeSD : 2925
     * sizeHD : 0
     * m3u8Hd_url : null
     * ptime : 2017-06-29 12:04:40
     */

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private int sizeSHD;
        private int replyCount;
        private String videosource;
        private Object mp4Hd_url;
        private String title;
        private String cover;
        /**
         * alias : 每日更新狗狗搞笑视频，文章。
         * tname : 狗狗在哪里
         * ename : T1492061880479
         * tid : T1492061880479
         * topic_icons : http://dingyue.nosdn.127.net/wDFxCuouZtCwq7cjZHll7Aoque=1PVWYJyH4IB3Spzxh91492061879579.jpg
         */

        private VideoTopicBean videoTopic;
        private String description;
        private String replyid;
        private int length;
        private String m3u8_url;
        private String vid;
        private String topicName;
        private int votecount;
        private String topicImg;
        private String topicDesc;
        private String topicSid;
        private String replyBoard;
        private int playCount;
        private String sectiontitle;
        private String mp4_url;
        private int playersize;
        private int sizeSD;
        private int sizeHD;
        private Object m3u8Hd_url;
        private String ptime;

        public int getSizeSHD() {
            return sizeSHD;
        }

        public void setSizeSHD(int sizeSHD) {
            this.sizeSHD = sizeSHD;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getVideosource() {
            return videosource;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public Object getMp4Hd_url() {
            return mp4Hd_url;
        }

        public void setMp4Hd_url(Object mp4Hd_url) {
            this.mp4Hd_url = mp4Hd_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public VideoTopicBean getVideoTopic() {
            return videoTopic;
        }

        public void setVideoTopic(VideoTopicBean videoTopic) {
            this.videoTopic = videoTopic;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getReplyid() {
            return replyid;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getM3u8_url() {
            return m3u8_url;
        }

        public void setM3u8_url(String m3u8_url) {
            this.m3u8_url = m3u8_url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getTopicImg() {
            return topicImg;
        }

        public void setTopicImg(String topicImg) {
            this.topicImg = topicImg;
        }

        public String getTopicDesc() {
            return topicDesc;
        }

        public void setTopicDesc(String topicDesc) {
            this.topicDesc = topicDesc;
        }

        public String getTopicSid() {
            return topicSid;
        }

        public void setTopicSid(String topicSid) {
            this.topicSid = topicSid;
        }

        public String getReplyBoard() {
            return replyBoard;
        }

        public void setReplyBoard(String replyBoard) {
            this.replyBoard = replyBoard;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public String getSectiontitle() {
            return sectiontitle;
        }

        public void setSectiontitle(String sectiontitle) {
            this.sectiontitle = sectiontitle;
        }

        public String getMp4_url() {
            return mp4_url;
        }

        public void setMp4_url(String mp4_url) {
            this.mp4_url = mp4_url;
        }

        public int getPlayersize() {
            return playersize;
        }

        public void setPlayersize(int playersize) {
            this.playersize = playersize;
        }

        public int getSizeSD() {
            return sizeSD;
        }

        public void setSizeSD(int sizeSD) {
            this.sizeSD = sizeSD;
        }

        public int getSizeHD() {
            return sizeHD;
        }

        public void setSizeHD(int sizeHD) {
            this.sizeHD = sizeHD;
        }

        public Object getM3u8Hd_url() {
            return m3u8Hd_url;
        }

        public void setM3u8Hd_url(Object m3u8Hd_url) {
            this.m3u8Hd_url = m3u8Hd_url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public static class VideoTopicBean {
            private String alias;
            private String tname;
            private String ename;
            private String tid;
            private String topic_icons;

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getTopic_icons() {
                return topic_icons;
            }

            public void setTopic_icons(String topic_icons) {
                this.topic_icons = topic_icons;
            }
        }
    }
}
