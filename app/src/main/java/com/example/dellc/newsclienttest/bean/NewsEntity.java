package com.example.dellc.newsclienttest.bean;

import java.util.List;

/**
 * Created by dellc on 2017/6/28.
 */

public class NewsEntity {


    private List<ResultBean> result;

    public static NewsEntity objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, NewsEntity.class);
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * postid : CO0THGH70008856R
         * hasCover : false
         * hasHead : 1
         * replyCount : 347
         * ltitle : 法国新总统座驾 国产DS7颜值高内饰很壕
         * hasImg : 1
         * digest : 版权声明：本文版权为网易汽车所有，转载请注明出处。网易汽车6月28日报道近日据悉，国产DS7CROSSBACK将2018年北京车展正式上市，新车定位紧凑级SUV
         * hasIcon : true
         * docid : CO0THGH70008856R
         * title : 法国新总统座驾 国产DS7颜值高内饰很壕
         * order : 1
         * wap_pluginfo : [{"title":"汽车大全","imgsrc":"http://img2.cache.netease.com/m/newsapp/qichedaquan.png","subtitle":"All Cars","url":"http://auto.3g.163.com/#RK001"},{"title":"底价买车","imgsrc":"http://img2.cache.netease.com/m/newsapp/zhidemai.png","subtitle":"Recommend","url":"http://auto.3g.163.com/bestsales/"},{"title":"汽车直播","imgsrc":"http://cms-bucket.nosdn.127.net/c58c8e11eaa84d128dabe703cc8d058220161229140946.png","subtitle":"Auto Live","url":"https://c.m.163.com/news/s/S1481872847862.html#RK002"}]
         * priority : 100
         * lmodify : 2017-06-28 12:03:06
         * auto_wap : [{"title":"汽车大全","imgsrc":"http://img2.cache.netease.com/m/newsapp/qichedaquan.png","subtitle":"All Cars","url":"http://auto.3g.163.com/#RK001"},{"title":"底价买车","imgsrc":"http://img2.cache.netease.com/m/newsapp/zhidemai.png","subtitle":"Recommend","url":"http://auto.3g.163.com/bestsales/"},{"title":"汽车直播","imgsrc":"http://cms-bucket.nosdn.127.net/c58c8e11eaa84d128dabe703cc8d058220161229140946.png","subtitle":"Auto Live","url":"https://c.m.163.com/news/s/S1481872847862.html#RK002"}]
         * boardid : auto_bbs
         * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348652751993.jpg
         * url_3w : http://auto.163.com/17/0628/10/CO0THGH70008856R.html
         * template : normal1
         * votecount : 227
         * alias : Autos
         * cid : C1348652751993
         * url : http://3g.163.com/auto/17/0628/10/CO0THGH70008856R.html
         * hasAD : 1
         * source : 网易汽车
         * ename : qiche
         * subtitle :
         * imgsrc : http://cms-bucket.nosdn.127.net/3ea3c57e7971469c814f438f174bc2ce20170628120302.jpeg
         * tname : 汽车
         * ptime : 2017-06-28 10:40:46
         * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/ff184947d292421abb1590341a1a3ce020170628073858.png"},{"imgsrc":"http://cms-bucket.nosdn.127.net/bbb39ead49c34fe08801f0c3e63acb1120170628073858.png"}]
         * skipID : 5BD20008|193173
         * skipType : photoset
         * photosetID : 5BD20008|193173
         * imgsum : 26
         * articleType : webview
         */

        private String postid;
        private boolean hasCover;
        private int hasHead;
        private int replyCount;
        private String ltitle;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private int order;
        private int priority;
        private String lmodify;
        private String boardid;
        private String topic_background;
        private String url_3w;
        private String template;
        private int votecount;
        private String alias;
        private String cid;
        private String url;
        private int hasAD;
        private String source;
        private String ename;
        private String subtitle;
        private String imgsrc;
        private String tname;
        private String ptime;
        private String skipID;
        private String skipType;
        private String photosetID;
        private int imgsum;
        private String articleType;
        private List<WapPluginfoBean> wap_pluginfo;
        private List<AutoWapBean> auto_wap;
        private List<ImgextraBean> imgextra;

        public static ResultBean objectFromData(String str) {

            return new com.google.gson.Gson().fromJson(str, ResultBean.class);
        }

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getLtitle() {
            return ltitle;
        }

        public void setLtitle(String ltitle) {
            this.ltitle = ltitle;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public String getUrl_3w() {
            return url_3w;
        }

        public void setUrl_3w(String url_3w) {
            this.url_3w = url_3w;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public int getImgsum() {
            return imgsum;
        }

        public void setImgsum(int imgsum) {
            this.imgsum = imgsum;
        }

        public String getArticleType() {
            return articleType;
        }

        public void setArticleType(String articleType) {
            this.articleType = articleType;
        }

        public List<WapPluginfoBean> getWap_pluginfo() {
            return wap_pluginfo;
        }

        public void setWap_pluginfo(List<WapPluginfoBean> wap_pluginfo) {
            this.wap_pluginfo = wap_pluginfo;
        }

        public List<AutoWapBean> getAuto_wap() {
            return auto_wap;
        }

        public void setAuto_wap(List<AutoWapBean> auto_wap) {
            this.auto_wap = auto_wap;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public static class WapPluginfoBean {
            /**
             * title : 汽车大全
             * imgsrc : http://img2.cache.netease.com/m/newsapp/qichedaquan.png
             * subtitle : All Cars
             * url : http://auto.3g.163.com/#RK001
             */

            private String title;
            private String imgsrc;
            private String subtitle;
            private String url;

            public static WapPluginfoBean objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, WapPluginfoBean.class);
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class AutoWapBean {
            /**
             * title : 汽车大全
             * imgsrc : http://img2.cache.netease.com/m/newsapp/qichedaquan.png
             * subtitle : All Cars
             * url : http://auto.3g.163.com/#RK001
             */

            private String title;
            private String imgsrc;
            private String subtitle;
            private String url;

            public static AutoWapBean objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, AutoWapBean.class);
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ImgextraBean {
            /**
             * imgsrc : http://cms-bucket.nosdn.127.net/ff184947d292421abb1590341a1a3ce020170628073858.png
             */

            private String imgsrc;

            public static ImgextraBean objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, ImgextraBean.class);
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }
    }
}
