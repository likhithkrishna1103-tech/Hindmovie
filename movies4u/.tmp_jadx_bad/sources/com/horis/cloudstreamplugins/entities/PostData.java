package com.horis.cloudstreamplugins.entities;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PostData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B«\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010!J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0007HÆ\u0003JÐ\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010>J\u0014\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010B\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010C\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b$\u0010!R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010-¨\u0006D"}, d2 = {"Lcom/horis/cloudstreamplugins/entities/PostData;", "", "desc", "", "director", "ua", "episodes", "", "Lcom/horis/cloudstreamplugins/entities/Episode;", "genre", "nextPage", "", "nextPageSeason", "nextPageShow", "season", "Lcom/horis/cloudstreamplugins/entities/Season;", "title", "year", "cast", "match", "runtime", "suggest", "Lcom/horis/cloudstreamplugins/entities/Suggest;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDesc", "()Ljava/lang/String;", "getDirector", "getUa", "getEpisodes", "()Ljava/util/List;", "getGenre", "getNextPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNextPageSeason", "getNextPageShow", "getSeason", "getTitle", "getYear", "getCast", "getMatch", "getRuntime", "getSuggest", "setSuggest", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/horis/cloudstreamplugins/entities/PostData;", "equals", "", "other", "hashCode", "toString", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PostData {

    @Nullable
    private final String cast;

    @Nullable
    private final String desc;

    @Nullable
    private final String director;

    @NotNull
    private final List<Episode> episodes;

    @Nullable
    private final String genre;

    @Nullable
    private final String match;

    @Nullable
    private final Integer nextPage;

    @Nullable
    private final String nextPageSeason;

    @Nullable
    private final Integer nextPageShow;

    @Nullable
    private final String runtime;

    @Nullable
    private final List<Season> season;

    @Nullable
    private List<Suggest> suggest;

    @NotNull
    private final String title;

    @Nullable
    private final String ua;

    @NotNull
    private final String year;

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getYear() {
        return this.year;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getCast() {
        return this.cast;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getMatch() {
        return this.match;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getRuntime() {
        return this.runtime;
    }

    @Nullable
    public final List<Suggest> component15() {
        return this.suggest;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDirector() {
        return this.director;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUa() {
        return this.ua;
    }

    @NotNull
    public final List<Episode> component4() {
        return this.episodes;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGenre() {
        return this.genre;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getNextPage() {
        return this.nextPage;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getNextPageSeason() {
        return this.nextPageSeason;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getNextPageShow() {
        return this.nextPageShow;
    }

    @Nullable
    public final List<Season> component9() {
        return this.season;
    }

    @NotNull
    public final PostData copy(@Nullable String desc, @Nullable String director, @Nullable String ua, @NotNull List<Episode> episodes, @Nullable String genre, @Nullable Integer nextPage, @Nullable String nextPageSeason, @Nullable Integer nextPageShow, @Nullable List<Season> season, @NotNull String title, @NotNull String year, @Nullable String cast, @Nullable String match, @Nullable String runtime, @Nullable List<Suggest> suggest) {
        return new PostData(desc, director, ua, episodes, genre, nextPage, nextPageSeason, nextPageShow, season, title, year, cast, match, runtime, suggest);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostData)) {
            return false;
        }
        PostData postData = (PostData) other;
        return Intrinsics.areEqual(this.desc, postData.desc) && Intrinsics.areEqual(this.director, postData.director) && Intrinsics.areEqual(this.ua, postData.ua) && Intrinsics.areEqual(this.episodes, postData.episodes) && Intrinsics.areEqual(this.genre, postData.genre) && Intrinsics.areEqual(this.nextPage, postData.nextPage) && Intrinsics.areEqual(this.nextPageSeason, postData.nextPageSeason) && Intrinsics.areEqual(this.nextPageShow, postData.nextPageShow) && Intrinsics.areEqual(this.season, postData.season) && Intrinsics.areEqual(this.title, postData.title) && Intrinsics.areEqual(this.year, postData.year) && Intrinsics.areEqual(this.cast, postData.cast) && Intrinsics.areEqual(this.match, postData.match) && Intrinsics.areEqual(this.runtime, postData.runtime) && Intrinsics.areEqual(this.suggest, postData.suggest);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((this.desc == null ? 0 : this.desc.hashCode()) * 31) + (this.director == null ? 0 : this.director.hashCode())) * 31) + (this.ua == null ? 0 : this.ua.hashCode())) * 31) + this.episodes.hashCode()) * 31) + (this.genre == null ? 0 : this.genre.hashCode())) * 31) + (this.nextPage == null ? 0 : this.nextPage.hashCode())) * 31) + (this.nextPageSeason == null ? 0 : this.nextPageSeason.hashCode())) * 31) + (this.nextPageShow == null ? 0 : this.nextPageShow.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + this.title.hashCode()) * 31) + this.year.hashCode()) * 31) + (this.cast == null ? 0 : this.cast.hashCode())) * 31) + (this.match == null ? 0 : this.match.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.suggest != null ? this.suggest.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostData(desc=").append(this.desc).append(", director=").append(this.director).append(", ua=").append(this.ua).append(", episodes=").append(this.episodes).append(", genre=").append(this.genre).append(", nextPage=").append(this.nextPage).append(", nextPageSeason=").append(this.nextPageSeason).append(", nextPageShow=").append(this.nextPageShow).append(", season=").append(this.season).append(", title=").append(this.title).append(", year=").append(this.year).append(", cast=");
        sb.append(this.cast).append(", match=").append(this.match).append(", runtime=").append(this.runtime).append(", suggest=").append(this.suggest).append(')');
        return sb.toString();
    }

    public PostData(@Nullable String desc, @Nullable String director, @Nullable String ua, @NotNull List<Episode> list, @Nullable String genre, @Nullable Integer nextPage, @Nullable String nextPageSeason, @Nullable Integer nextPageShow, @Nullable List<Season> list2, @NotNull String title, @NotNull String year, @Nullable String cast, @Nullable String match, @Nullable String runtime, @Nullable List<Suggest> list3) {
        this.desc = desc;
        this.director = director;
        this.ua = ua;
        this.episodes = list;
        this.genre = genre;
        this.nextPage = nextPage;
        this.nextPageSeason = nextPageSeason;
        this.nextPageShow = nextPageShow;
        this.season = list2;
        this.title = title;
        this.year = year;
        this.cast = cast;
        this.match = match;
        this.runtime = runtime;
        this.suggest = list3;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final String getDirector() {
        return this.director;
    }

    @Nullable
    public final String getUa() {
        return this.ua;
    }

    @NotNull
    public final List<Episode> getEpisodes() {
        return this.episodes;
    }

    @Nullable
    public final String getGenre() {
        return this.genre;
    }

    @Nullable
    public final Integer getNextPage() {
        return this.nextPage;
    }

    @Nullable
    public final String getNextPageSeason() {
        return this.nextPageSeason;
    }

    @Nullable
    public final Integer getNextPageShow() {
        return this.nextPageShow;
    }

    @Nullable
    public final List<Season> getSeason() {
        return this.season;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getYear() {
        return this.year;
    }

    @Nullable
    public final String getCast() {
        return this.cast;
    }

    @Nullable
    public final String getMatch() {
        return this.match;
    }

    @Nullable
    public final String getRuntime() {
        return this.runtime;
    }

    @Nullable
    public final List<Suggest> getSuggest() {
        return this.suggest;
    }

    public final void setSuggest(@Nullable List<Suggest> list) {
        this.suggest = list;
    }
}
