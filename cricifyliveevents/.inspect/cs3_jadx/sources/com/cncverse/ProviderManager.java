package com.cncverse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProviderManager.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/cricifyliveevents/.inspect/cs3/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000f\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\rJ \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b0\nH\u0086@¢\u0006\u0002\u0010\rJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nH\u0086@¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/cncverse/ProviderManager;", "", "<init>", "()V", "DEFAULT_BASE_URL", "", "cachedBaseUrl", "client", "Lokhttp3/OkHttpClient;", "fallbackProviders", "", "", "getBaseUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProvidersUrl", "getLiveEventsUrl", "fetchProviders", "fetchLiveEvents", "Lcom/cncverse/LiveEventData;", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,240:1\n1#2:241\n*E\n"})
public final class ProviderManager {

    @NotNull
    private static final String DEFAULT_BASE_URL = "https://cfymarkscanjiostar80.top";

    @Nullable
    private static String cachedBaseUrl;

    @NotNull
    public static final ProviderManager INSTANCE = new ProviderManager();

    @NotNull
    private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

    @NotNull
    private static final List<Map<String, Object>> fallbackProviders = CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 13), TuplesKt.to("title", "TATA PLAY"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQz_qYe3Y4S5bXXVlPtXQnqtAkLw1-no57QHhPyMgWE0SQmxujzHxZKiDs&s=10"), TuplesKt.to("catLink", "https://hotstarlive.delta-cloud.workers.dev/?token=240bb9-374e2e-3c13f0-4a7xz5")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 14), TuplesKt.to("title", "HOTSTAR"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWwYjMvB58DMLsL9Ii2fhvw6NBYvD1iVCjOMU8TXBLJt0eibLGOjoRkLJP&s=10"), TuplesKt.to("catLink", "https://hotstar-live-event.alpha-circuit.workers.dev/?token=a13d9c-4b782a-6c90fd-9a1b84")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 15), TuplesKt.to("title", "TATAPLAY BD"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQz_qYe3Y4S5bXXVlPtXQnqtAkLw1-no57QHhPyMgWE0SQmxujzHxZKiDs&s=10"), TuplesKt.to("catLink", "https://ranapk.short.gy/BDIX/tata.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 17), TuplesKt.to("title", "T SPORTS "), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJ0QvfKyjAqcCOumIXjcuYg505GnaBeVk2lQ&usqp=CAU "), TuplesKt.to("catLink", "https://fifabangladesh2-xyz-ekkj.spidy.online/AYN/tsports.m3u  ")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 18), TuplesKt.to("title", "FANCODE IND"), TuplesKt.to("image", "https://play-lh.googleusercontent.com/lp1Tdhp75MQyrHqrsyRBV74HxoL3Ko8KRAjOUI1wUHREAxuuVwKR6vnamgvMEn4C4Q"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/Jitendra-unatti/fancode/refs/heads/main/data/fancode.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 19), TuplesKt.to("title", "SONYLIV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzscCrHEfnHNeZdMO3haF1XSVgjskN4TNv0g&usqp=CAU "), TuplesKt.to("catLink", "https://raw.githubusercontent.com/doctor-8trange/zyphora/refs/heads/main/data/sony.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 22), TuplesKt.to("title", "JIO IND"), TuplesKt.to("image", "https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/jio-logo-icon.png "), TuplesKt.to("catLink", "https://jiotv.byte-vault.workers.dev/?token=42e4f5-2d873b-3c37d8-7f3f50")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 29), TuplesKt.to("title", "SONY IN"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxsCm4WKugE7ubLr2J3AP7s-hqHl0dh69ImA&usqp=CAU"), TuplesKt.to("catLink", "https://sonyliv.logic-lane.workers.dev?token=a14d9c-4b782a-6c90fd-9a1b84")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 31), TuplesKt.to("title", "SONY IN 2"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxsCm4WKugE7ubLr2J3AP7s-hqHl0dh69ImA&usqp=CAU"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/ramnarayan01/data/refs/heads/main/s0nyind.m3u.html")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 48), TuplesKt.to("title", "SUN DIRECT"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwc4OuqPmOP-Fi9dhfiDw_q-s3rOmgCPla_IaE76VD2KRQ7c4KHeI2zJY&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/suntv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 70), TuplesKt.to("title", "VOOT BD"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfS6QZFts2FoedMGZE28H7Kh158PsrNIiabFBVJMy_jXa8Tvvb9WAlut8&s=10"), TuplesKt.to("catLink", "https://ranapk.short.gy/VOOTBD.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 71), TuplesKt.to("title", "VOOT IND"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfS6QZFts2FoedMGZE28H7Kh158PsrNIiabFBVJMy_jXa8Tvvb9WAlut8&s=10"), TuplesKt.to("catLink", "https://jiocinema-live.cloud-hatchh.workers.dev/?token=42e4f5-2d414b-3c37d8-5f3f45")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 85), TuplesKt.to("title", "SUN NXT"), TuplesKt.to("image", "https://upload.wikimedia.org/wikipedia/en/d/d5/Sun_NXT_logo_small.png"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alexandermail371/cricfytv/refs/heads/main/sunxt.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 90), TuplesKt.to("title", "AIRTEL IND"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQf7pkggfHJKj2R8O6ttuHxgv-vQVL03xUeAg&usqp=CAU"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/artl.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 92), TuplesKt.to("title", "DISTRO TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYQjBTT5SL_kuJF7CbQtoSEA7PzyiH9RYIuDO9F1sx87CtiULDyiDf7ybt&s=10"), TuplesKt.to("catLink", "https://playlist-storage.pages.dev/PLAYLIST/DistroTV.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 104), TuplesKt.to("title", "ZEE5"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQS0OT2NFe9Jb4ofg_DrXx42EKLgyGnSGwoLg&usqp=CAU"), TuplesKt.to("catLink", "https://zee5.cloud-hatchh.workers.dev/?token=42e4f5-2d413b-3c37d8-7f3f35")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 106), TuplesKt.to("title", "JIOTV+"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRh5KeAyYdOyxaCWDPbiUsJW7Oy4v_7uFqf06rIwGxaWc6nQuNVqZ2Q_Qej&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/jtv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 110), TuplesKt.to("title", "JIOLIVE IND"), TuplesKt.to("image", "https://lens-storage.storage.googleapis.com/png/bb364a303da24e5db23f01bac26949cf"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/jc_live/refs/heads/main/jevents_live.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 111), TuplesKt.to("title", "ISLAMIC TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcTOpdBeIBA52NTSANHC6Ow0v-k6hAr76vWg&usqp=CAU"), TuplesKt.to("catLink", "null")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 114), TuplesKt.to("title", "TAPMAD PK"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4X-7suwtvYWwoa6m0ngFTKZt5Hg5Z2kQF1g&usqp=CAU"), TuplesKt.to("catLink", "https://tv.noobon.top/playlist/tapmad.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 117), TuplesKt.to("title", "ZEE5 IN"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQS0OT2NFe9Jb4ofg_DrXx42EKLgyGnSGwoLg&usqp=CAU"), TuplesKt.to("catLink", "https://ranapk.short.gy/Z5in.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 126), TuplesKt.to("title", "WORLD TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSg8OiEwOT5UL5UttBZ5Tnhgsod8i2EQlfB97FFchdBOo8e_PfxvR8RJ68&s=10"), TuplesKt.to("catLink", "https://ranapk.short.gy/WorldTV11.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 129), TuplesKt.to("title", "AYNA"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvAant65yQ_au1e51MFs-uiE6juswXv4ZJoNCpzBBSg4q7DzJ1NeliS80c&s=10"), TuplesKt.to("catLink", "https://playlist-cricfy.noobon.top/aynaott.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 130), TuplesKt.to("title", "JIO CINEMA IND"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQc3qZ1WgzPyFRX4cWIBJF0MSjWW3gZcLFycg&usqp=CAU"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/jcinema.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 131), TuplesKt.to("title", "DISH TV"), TuplesKt.to("image", "https://m.media-amazon.com/images/S/stores-image-uploads-eu-prod/1/AmazonStores/A21TJRUUN4KGV/d5086253b614724be106c06be13f7d54.w600.h600._RO299,1,0,0,0,0,0,0,0,0,15_FMpng_.jpg"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/dishtv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 132), TuplesKt.to("title", "SHOOQ PK"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvSWLnpgyvbzV9rHkREzbsX1Rzh2IbEZBL8yPpSv8aCPmy1nVcv7BhIWQ&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/shoq.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 133), TuplesKt.to("title", "SAMSUNG TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQI9T5vcm8wU-dLuaK5vBfoHpz8KL9Ru0aU1eoVaKNcqauxGtRTfvI1rGTA&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/samsungtv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 134), TuplesKt.to("title", "JAGOBD"), TuplesKt.to("image", "https://www.jagobd.com/wp-content/uploads/2015/10/web_hi_res_512.png"), TuplesKt.to("catLink", "https://tv.noobon.top/playlist/jagobd.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 135), TuplesKt.to("title", "JADOO"), TuplesKt.to("image", "https://bdix.net/wp-content/uploads/2019/07/Jadoo-Digital-Logo-PNG-1002x1024.png"), TuplesKt.to("catLink", "https://fifabangladesh.site/PLAYLIST/jadoo.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 136), TuplesKt.to("title", "PISHOW"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1hOo397X8uamgdXoknED8klICRLPCqwuEUtB394H2cc7YIyYiD78s-B8&s=10"), TuplesKt.to("catLink", "http://playlist-storage.pages.dev/PLAYLIST/playboxtv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 146), TuplesKt.to("title", "CRICHD"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ08h1gOe7MPxwehZBrbYKAUtjv22B6rAJ1kMkN-cea64Ka49KUyGU2lpTz&s=10"), TuplesKt.to("catLink", "https://github.com/abusaeeidx/CricHd-playlists-Auto-Update-permanent/raw/main/ALL.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 150), TuplesKt.to("title", "ZAP SPORTS"), TuplesKt.to("image", "https://i.ibb.co/dJfysm3V/zap-Sports.png"), TuplesKt.to("catLink", "https://tv.noobon.top/zapx/api.php?action=getIPTVPlaylist")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 151), TuplesKt.to("title", "Pirates TV"), TuplesKt.to("image", "https://raw.githubusercontent.com/FunctionError/Logos/main/Pirates-Tv.png"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/FunctionError/PiratesTv/refs/heads/main/combined_playlist.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 152), TuplesKt.to("title", "YUPPTV"), TuplesKt.to("image", "https://d229kpbsb5jevy.cloudfront.net/bott/v2/networks/circularimages/yupptv.png"), TuplesKt.to("catLink", "https://tv.noobon.top/playlist/yapp.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 153), TuplesKt.to("title", "DANGAL TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMnDuHwjd3WEFHmObqo53bAjkIB6E7JvIIPjGGGxqZzbNsKT85D_sRYNc&s=10"), TuplesKt.to("catLink", "https://playlist-storage.pages.dev/PLAYLIST/DangalPlay.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 157), TuplesKt.to("title", "Movies & Series"), TuplesKt.to("image", "https://i.postimg.cc/QCVVj6D1/Movies.png"), TuplesKt.to("catLink", "http://tv.noobon.top/playlist/movies.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 158), TuplesKt.to("title", "DEKHO 24 X 7"), TuplesKt.to("image", "https://tstatic.videoready.tv/cms-ui/images/custom-content/1739684250358.png"), TuplesKt.to("catLink", "https://dehkho24h.alpha-circuit.workers.dev/?token=1b8j9b-796c8a-36e17f-8f83a5")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 159), TuplesKt.to("title", "JIOTV+ S2"), TuplesKt.to("image", "https://i.ibb.co/VY9ND7rY/image.png"), TuplesKt.to("catLink", "https://jiotvplus.byte-vault.workers.dev/?token=42e4f5-2d863b-3c38d8-7f3f51")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 163), TuplesKt.to("title", "JIOHOTSTAR"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPuz9ekmjh3vEpEc3lYL4nh6Gj7y2CQTswVG-ZCHnIS1foScuwPzuyxic&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/jstar.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 164), TuplesKt.to("title", "JIOTV+ S3"), TuplesKt.to("image", "https://i.ibb.co/VY9ND7rY/image.png"), TuplesKt.to("catLink", "https://jiotv.edge-nexus.workers.dev/?token=42e4f5-2d863b-3c37d8-8f3f51")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 165), TuplesKt.to("title", "ICC TV"), TuplesKt.to("image", "https://m.media-amazon.com/images/I/31F7ropt9OL.png"), TuplesKt.to("catLink", "https://icc.alpha-circuit.workers.dev/?token=42e4f5-2d863b-3c37d8-7f3f69")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 166), TuplesKt.to("title", "Pluto Tv"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRI_jYjppElN7Tb6Ok3bL_J0K7QQPzfQbzPeAWzVilH9y7CYKzAy-XJbi4&s=10"), TuplesKt.to("catLink", "https://tv.noobon.top/playlist/plutotv.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 167), TuplesKt.to("title", "Movies"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZsNCiIfBGnyhPuE6n-t37ma_baSTkX_trJ45qtXvwLhxsdVWzNW0dt8u7&s=10"), TuplesKt.to("catLink", "ok")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 168), TuplesKt.to("title", "FANCODE BD"), TuplesKt.to("image", "https://play-lh.googleusercontent.com/lp1Tdhp75MQyrHqrsyRBV74HxoL3Ko8KRAjOUI1wUHREAxuuVwKR6vnamgvMEn4C4Q"), TuplesKt.to("catLink", "https://ranapk.short.gy/FCBD/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 169), TuplesKt.to("title", "EPL BD IP"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQye0cNsXab_lPM3Zv2pklCk2ZT92X3micxy7jF2n5F46-kaSgnIBjHq3KY&s=10"), TuplesKt.to("catLink", "https://bdix.short.gy/EPLxBDIX/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 170), TuplesKt.to("title", "JIO BD"), TuplesKt.to("image", "https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/jio-logo-icon.png"), TuplesKt.to("catLink", "https://ranapk.short.gy/JIOBD.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 173), TuplesKt.to("title", "World Sports"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7iSlqAmYv4wa-7P9aRqiLVniqbUQUtVNmgsf4BxJJqpRKNJVhlVHvFKI&s=10"), TuplesKt.to("catLink", "https://tv.xmasterbd.sbs/dhd/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 174), TuplesKt.to("title", "Prime Channel"), TuplesKt.to("image", "https://static.vecteezy.com/system/resources/previews/046/437/251/non_2x/amazon-prime-logo-free-png.png"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/amzusa.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 175), TuplesKt.to("title", "RUN TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7zqXTonSH_Xo--YxMlOacinf7mhLwuwSFFF1KJa8lGw&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/runn.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 176), TuplesKt.to("title", "WAVES OTT"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNyx_lxD3xXIB8jpFGnMnHZIziUo1vKW9sSS-7zP-h0vhZT4cPB6wly6o&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/waves.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 177), TuplesKt.to("title", "JIO IND2"), TuplesKt.to("image", "https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/jio-logo-icon.png"), TuplesKt.to("catLink", "https://playlist-cricfy.noobon.top/noob/jiotv.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 178), TuplesKt.to("title", "JIOTV+ S4"), TuplesKt.to("image", "https://i.ibb.co/VY9ND7rY/image.png"), TuplesKt.to("catLink", "https://jiotvplus.iron-shield.workers.dev/?token=42e4f5-2d963b-3c37d8-7f3f52")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 179), TuplesKt.to("title", "LGTV IND"), TuplesKt.to("image", "https://raw.githubusercontent.com/alex8875/img/refs/heads/main/LG_tv.png"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/lgtv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 180), TuplesKt.to("title", "TOFFEE BD"), TuplesKt.to("image", "https://yt3.googleusercontent.com/q0CJuxOL2f7Duy3hiM3uKArC_Zvji24XVGNfcf2TMqXMxTW6RO3R3tqwH2XAxbcz5TG-d2p6=s900-c-k-c0x00ffffff-no-rj"), TuplesKt.to("catLink", "https://playlist-cricfy.noobon.top/toffee.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 181), TuplesKt.to("title", "ZEE5 IN 2"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQS0OT2NFe9Jb4ofg_DrXx42EKLgyGnSGwoLg&usqp=CAU"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/z5.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 182), TuplesKt.to("title", "SONY BD"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxsCm4WKugE7ubLr2J3AP7s-hqHl0dh69ImA&usqp=CAU"), TuplesKt.to("catLink", "https://ranapk.short.gy/sonybd/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 183), TuplesKt.to("title", "AYNA 2"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvAant65yQ_au1e51MFs-uiE6juswXv4ZJoNCpzBBSg4q7DzJ1NeliS80c&s=10"), TuplesKt.to("catLink", "https://bdix2.short.gy/AYNA/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 184), TuplesKt.to("title", "DARK TV"), TuplesKt.to("image", "https://i.ibb.co/CsQCkNnb/Screenshot-2025-11-04-06-03-45-53.jpg"), TuplesKt.to("catLink", "https://ranapk.short.gy/Darktv/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 185), TuplesKt.to("title", "AKASH"), TuplesKt.to("image", "https://image.winudf.com/v2/image1/Y29tLmFrYXNoLmdvX2ljb25fMTcyMjU3ODg2N18wNTA/icon.png?w=184&fakeurl=1"), TuplesKt.to("catLink", "https://playlist-cricfy.noobon.top/akashgo.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 186), TuplesKt.to("title", "FREE TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTS4HoWswvKYjnMyenamwz-xBJq0PLSyZYpo0kp3oN6gw&s=10"), TuplesKt.to("catLink", "https://playlist-storage.pages.dev/PLAYLIST/freetv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 187), TuplesKt.to("title", "FANCODE BD 2"), TuplesKt.to("image", "https://play-lh.googleusercontent.com/lp1Tdhp75MQyrHqrsyRBV74HxoL3Ko8KRAjOUI1wUHREAxuuVwKR6vnamgvMEn4C4Q"), TuplesKt.to("catLink", "https://ranapk.short.gy/FcOnlyBD/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 188), TuplesKt.to("title", "DISH HOME BD"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfc5DoDgZ5r5s1_umhMp0UUBENdkOUdWWFcSAzv-EUxA&s"), TuplesKt.to("catLink", "https://dish.data-vortex.workers.dev?token=42e4f5-2d863b-3c37d8-7f3f51")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 189), TuplesKt.to("title", "ZEE5 LIVE"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQS0OT2NFe9Jb4ofg_DrXx42EKLgyGnSGwoLg&usqp=CAU"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/doctor-8trange/quarnex/refs/heads/main/data/zee5.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 190), TuplesKt.to("title", "FREE SPORTS"), TuplesKt.to("image", "https://media.unreel.me/prod/freelivesports/general/6496be67-a318-46c6-a25d-93c161f86845"), TuplesKt.to("catLink", "https://playlist-storage.pages.dev/PLAYLIST/freelivesports.m3u")})});

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$getBaseUrl$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager", f = "ProviderManager.kt", i = {}, l = {137}, m = "getBaseUrl", n = {}, nl = {138}, s = {}, v = 2)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProviderManager.this.getBaseUrl((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$getLiveEventsUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager", f = "ProviderManager.kt", i = {}, l = {161}, m = "getLiveEventsUrl", n = {}, nl = {162}, s = {}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProviderManager.this.getLiveEventsUrl((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$getProvidersUrl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager", f = "ProviderManager.kt", i = {}, l = {153}, m = "getProvidersUrl", n = {}, nl = {154}, s = {}, v = 2)
    static final class C00091 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProviderManager.this.getProvidersUrl((Continuation) this);
        }
    }

    private ProviderManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getBaseUrl(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.cncverse.ProviderManager.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            com.cncverse.ProviderManager$getBaseUrl$1 r0 = (com.cncverse.ProviderManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r1 = r0.label
            int r1 = r1 - r2
            r0.label = r1
            goto L19
        L14:
            com.cncverse.ProviderManager$getBaseUrl$1 r0 = new com.cncverse.ProviderManager$getBaseUrl$1
            r0.<init>(r7)
        L19:
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 1
            switch(r3) {
                case 0: goto L32;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2d:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r1
            goto L46
        L32:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.String r3 = com.cncverse.ProviderManager.cachedBaseUrl
            if (r3 == 0) goto L3b
            r2 = 0
            return r3
        L3b:
            com.cncverse.FirebaseRemoteConfigFetcher r3 = com.cncverse.FirebaseRemoteConfigFetcher.INSTANCE
            r0.label = r4
            java.lang.Object r3 = r3.getProviderApiUrl(r0)
            if (r3 != r2) goto L46
            return r2
        L46:
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r5 = 0
            if (r3 == 0) goto L58
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 == 0) goto L56
            goto L58
        L56:
            r3 = 0
            goto L59
        L58:
            r3 = 1
        L59:
            if (r3 != 0) goto L6d
            char[] r3 = new char[r4]
            r4 = 47
            r3[r5] = r4
            java.lang.String r3 = kotlin.text.StringsKt.trimEnd(r2, r3)
            com.cncverse.ProviderManager.cachedBaseUrl = r3
            java.lang.String r3 = com.cncverse.ProviderManager.cachedBaseUrl
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            return r3
        L6d:
            java.lang.String r3 = "https://cfymarkscanjiostar80.top"
            com.cncverse.ProviderManager.cachedBaseUrl = r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.ProviderManager.getBaseUrl(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getProvidersUrl(kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.cncverse.ProviderManager.C00091
            if (r0 == 0) goto L14
            r0 = r6
            com.cncverse.ProviderManager$getProvidersUrl$1 r0 = (com.cncverse.ProviderManager.C00091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r1 = r0.label
            int r1 = r1 - r2
            r0.label = r1
            goto L19
        L14:
            com.cncverse.ProviderManager$getProvidersUrl$1 r0 = new com.cncverse.ProviderManager$getProvidersUrl$1
            r0.<init>(r6)
        L19:
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            switch(r3) {
                case 0: goto L31;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2c:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r1
            goto L3e
        L31:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = 1
            r0.label = r3
            java.lang.Object r3 = r5.getBaseUrl(r0)
            if (r3 != r2) goto L3e
            return r2
        L3e:
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r2)
            java.lang.String r4 = "/cats.txt"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.ProviderManager.getProvidersUrl(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getLiveEventsUrl(kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.cncverse.ProviderManager.C00081
            if (r0 == 0) goto L14
            r0 = r6
            com.cncverse.ProviderManager$getLiveEventsUrl$1 r0 = (com.cncverse.ProviderManager.C00081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r1 = r0.label
            int r1 = r1 - r2
            r0.label = r1
            goto L19
        L14:
            com.cncverse.ProviderManager$getLiveEventsUrl$1 r0 = new com.cncverse.ProviderManager$getLiveEventsUrl$1
            r0.<init>(r6)
        L19:
            java.lang.Object r1 = r0.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            switch(r3) {
                case 0: goto L31;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2c:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r1
            goto L3e
        L31:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = 1
            r0.label = r3
            java.lang.Object r3 = r5.getBaseUrl(r0)
            if (r3 != r2) goto L3e
            return r2
        L3e:
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r2)
            java.lang.String r4 = "/categories/live-events.txt"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.ProviderManager.getLiveEventsUrl(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$fetchProviders$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager$fetchProviders$2", f = "ProviderManager.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, nl = {171}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchProviders$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,240:1\n15#2:241\n50#3:242\n43#3:243\n777#4:244\n873#4,2:245\n1586#4:247\n1661#4,3:248\n*S KotlinDebug\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchProviders$2\n*L\n182#1:241\n182#1:242\n182#1:243\n184#1:244\n184#1:245,2\n185#1:247\n185#1:248,3\n*E\n"})
    static final class C00072 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>>, Object> {
        int label;

        C00072(Continuation<? super C00072> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00072(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object providersUrl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        providersUrl = ProviderManager.INSTANCE.getProvidersUrl((Continuation) this);
                        if (providersUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        providersUrl = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String providersUrl2 = (String) providersUrl;
                Request request = new Request.Builder().url(providersUrl2).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                Response response = ProviderManager.client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String encryptedData = response.body().string();
                    String str = encryptedData;
                    if (!(str == null || StringsKt.isBlank(str))) {
                        String decryptedData = CryptoUtils.INSTANCE.decryptData(StringsKt.trim(encryptedData).toString());
                        String str2 = decryptedData;
                        if (!(str2 == null || StringsKt.isBlank(str2))) {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                            Iterable providers = (List) $this$readValue$iv$iv.readValue(decryptedData, new TypeReference<List<? extends ProviderData>>() { // from class: com.cncverse.ProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                            });
                            Iterable $this$filter$iv = providers;
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                ProviderData it = (ProviderData) element$iv$iv;
                                String catLink = it.getCatLink();
                                if (!(catLink == null || StringsKt.isBlank(catLink))) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            Iterable $this$map$iv = (List) destination$iv$iv;
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                ProviderData provider = (ProviderData) item$iv$iv;
                                String catLink2 = provider.getCatLink();
                                Intrinsics.checkNotNull(catLink2);
                                destination$iv$iv2.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("id", Boxing.boxInt(provider.getId())), TuplesKt.to("title", provider.getTitle()), TuplesKt.to("image", provider.getImage()), TuplesKt.to("catLink", catLink2)}));
                                request = request;
                            }
                            return (List) destination$iv$iv2;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ProviderManager.fallbackProviders;
        }
    }

    @Nullable
    public final Object fetchProviders(@NotNull Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00072(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$fetchLiveEvents$2, reason: invalid class name */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/LiveEventData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager$fetchLiveEvents$2", f = "ProviderManager.kt", i = {}, l = {214}, m = "invokeSuspend", n = {}, nl = {216}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchLiveEvents$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,240:1\n15#2:241\n50#3:242\n43#3:243\n777#4:244\n873#4,2:245\n*S KotlinDebug\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchLiveEvents$2\n*L\n227#1:241\n227#1:242\n227#1:243\n229#1:244\n229#1:245,2\n*E\n"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends LiveEventData>>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<LiveEventData>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object liveEventsUrl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        liveEventsUrl = ProviderManager.INSTANCE.getLiveEventsUrl((Continuation) this);
                        if (liveEventsUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        liveEventsUrl = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String liveEventsUrl2 = (String) liveEventsUrl;
                Request request = new Request.Builder().url(liveEventsUrl2).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                Response response = ProviderManager.client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String encryptedData = response.body().string();
                    String str = encryptedData;
                    if (!(str == null || StringsKt.isBlank(str))) {
                        String decryptedData = CryptoUtils.INSTANCE.decryptData(StringsKt.trim(encryptedData).toString());
                        String str2 = decryptedData;
                        if (!(str2 == null || StringsKt.isBlank(str2))) {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                            Iterable events = (List) $this$readValue$iv$iv.readValue(decryptedData, new TypeReference<List<? extends LiveEventData>>() { // from class: com.cncverse.ProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                            });
                            Iterable $this$filter$iv = events;
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                LiveEventData it = (LiveEventData) element$iv$iv;
                                if (it.getPublish() == 1) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            return (List) destination$iv$iv;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return CollectionsKt.emptyList();
        }
    }

    @Nullable
    public final Object fetchLiveEvents(@NotNull Continuation<? super List<LiveEventData>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }
}
