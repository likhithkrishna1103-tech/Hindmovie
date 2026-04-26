package com.megix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ProviderRegistry.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/movies4u/.jadx/cinestream/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/megix/ProviderRegistry;", "", "<init>", "()V", "builtInProviders", "", "Lcom/megix/ProviderDef;", "getBuiltInProviders", "()Ljava/util/List;", "keys", "", "getKeys", "namesMap", "", "getNamesMap", "()Ljava/util/Map;", "torrentKeys", "", "getTorrentKeys", "()Ljava/util/Set;", "CineStream"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nProviderRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderRegistry.kt\ncom/megix/ProviderRegistry\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,385:1\n1586#2:386\n1661#2,3:387\n1205#2,2:390\n1282#2,4:392\n777#2:396\n873#2,2:397\n1586#2:399\n1661#2,3:400\n*S KotlinDebug\n*F\n+ 1 ProviderRegistry.kt\ncom/megix/ProviderRegistry\n*L\n381#1:386\n381#1:387,3\n382#1:390,2\n382#1:392,4\n383#1:396\n383#1:397,2\n383#1:399\n383#1:400,3\n*E\n"})
public final class ProviderRegistry {

    @NotNull
    public static final ProviderRegistry INSTANCE = new ProviderRegistry();

    @NotNull
    private static final List<ProviderDef> builtInProviders;

    private ProviderRegistry() {
    }

    static {
        Function5 function5 = null;
        Function5 function52 = null;
        Function5 function53 = null;
        Function5 function54 = null;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Function5 function55 = null;
        Function5 function56 = null;
        Function5 function57 = null;
        Function5 function58 = null;
        Function5 function59 = null;
        Function5 function510 = null;
        Function5 function511 = null;
        Function5 function512 = null;
        Function5 function513 = null;
        Function5 function514 = null;
        Function5 function515 = null;
        Function5 function516 = null;
        Function5 function517 = null;
        Function5 function518 = null;
        Function5 function519 = null;
        Function5 function520 = null;
        Function5 function521 = null;
        Function5 function522 = null;
        Function5 function523 = null;
        Function5 function524 = null;
        Function5 function525 = null;
        Function5 function526 = null;
        Function5 function527 = null;
        Function5 function528 = null;
        Function5 function529 = null;
        Function5 function530 = null;
        Function5 function531 = null;
        Function5 function532 = null;
        Function5 function533 = null;
        Function5 function534 = null;
        Function5 function535 = null;
        Function5 function536 = null;
        Function5 function537 = null;
        Function5 function538 = null;
        Function5 function539 = null;
        Function5 function540 = null;
        builtInProviders = CollectionsKt.listOf(new ProviderDef[]{new ProviderDef("p_meteor", "🧲 Meteor", true, new ProviderRegistry$builtInProviders$1(null), new ProviderRegistry$builtInProviders$2(null), null, 32, null), new ProviderDef("p_torrentsdb", "🧲 TorrentsDB", true, new ProviderRegistry$builtInProviders$3(null), new ProviderRegistry$builtInProviders$4(null), null, 32, null), new ProviderDef("p_animetosho", "🧲 AnimeTosho", true, null, new ProviderRegistry$builtInProviders$5(null), function5, 40, null), new ProviderDef("p_streamvix", "Streamvix", false, new ProviderRegistry$builtInProviders$6(null), function5, function52, 52, null), new ProviderDef("p_notorrent", "NoTorrent", false, new ProviderRegistry$builtInProviders$7(null), function52, null, 52, null), new ProviderDef("p_castle", "Castle", false, new ProviderRegistry$builtInProviders$8(null), new ProviderRegistry$builtInProviders$9(null), function53, 36, null), new ProviderDef("p_cine", "Cine", false, new ProviderRegistry$builtInProviders$10(null), function53, null, 52, null), new ProviderDef("p_wyziesubs", "WYZIESubs", false, new ProviderRegistry$builtInProviders$11(null), new ProviderRegistry$builtInProviders$12(null), null, 36, null), new ProviderDef("p_stremiosubs", "StremioSubs", false, new ProviderRegistry$builtInProviders$13(null), new ProviderRegistry$builtInProviders$14(null), null, 36, null), new ProviderDef("p_showbox", "ShowBox", false, new ProviderRegistry$builtInProviders$15(null), new ProviderRegistry$builtInProviders$16(null), function54, 36, null), new ProviderDef("p_vidflix", "Vidflix", false, new ProviderRegistry$builtInProviders$17(null), function54, function55, 52, defaultConstructorMarker), new ProviderDef("p_vidrock", "Vidrock", false, new ProviderRegistry$builtInProviders$18(null), null, null, 52, null), new ProviderDef("p_moviebox", "Moviebox", false, new ProviderRegistry$builtInProviders$19(null), new ProviderRegistry$builtInProviders$20(null), null, 36, null), new ProviderDef("p_cinemacity", "Cinemacity", false, new ProviderRegistry$builtInProviders$21(null), new ProviderRegistry$builtInProviders$22(null), function56, 36, null), new ProviderDef("p_allmovieland", "Allmovieland", false, new ProviderRegistry$builtInProviders$23(null), function56, function57, 52, null), new ProviderDef("p_madplaycdn", "MadplayCDN", false, new ProviderRegistry$builtInProviders$24(null), function57, function58, 52, null), new ProviderDef("p_hexa", "Hexa", false, new ProviderRegistry$builtInProviders$25(null), function58, function59, 52, null), new ProviderDef("p_yflix", "Yflix", false, new ProviderRegistry$builtInProviders$26(null), function59, function510, 52, function54), new ProviderDef("p_xpass", "Xpass", false, new ProviderRegistry$builtInProviders$27(null), function510, function511, 52, function55), new ProviderDef("p_playsrc", "Playsrc", false, new ProviderRegistry$builtInProviders$28(null), function511, function512, 52, null), new ProviderDef("p_2embed", "2Embed", false, new ProviderRegistry$builtInProviders$29(null), function512, function513, 52, defaultConstructorMarker), new ProviderDef("p_videasy", "Videasy", false, new ProviderRegistry$builtInProviders$30(null), null, function514, 52, null), new ProviderDef("p_cinemaos", "CinemaOS", false, new ProviderRegistry$builtInProviders$31(null), function514, function515, 52, null), new ProviderDef("p_vicsrcwtf", "VicSrcWtf", false, new ProviderRegistry$builtInProviders$32(null), function515, function516, 52, null), new ProviderDef("p_vidlink", "Vidlink", false, new ProviderRegistry$builtInProviders$33(null), function516, null, 52, null), new ProviderDef("p_pulp", "Pulp", false, new ProviderRegistry$builtInProviders$34(null), new ProviderRegistry$builtInProviders$35(null), function517, 36, null), new ProviderDef("p_mapple", "Mapple", false, new ProviderRegistry$builtInProviders$36(null), function517, function518, 52, null), new ProviderDef("p_vidstack", "Vidstack", false, new ProviderRegistry$builtInProviders$37(null), function518, function519, 52, function512), new ProviderDef("p_vidzee", "Vidzee", false, new ProviderRegistry$builtInProviders$38(null), function519, function520, 52, function513), new ProviderDef("p_vidfastpro", "VidFastPro", false, new ProviderRegistry$builtInProviders$39(null), function520, null, 52, null), new ProviderDef("p_netflix", "Netflix", false, new ProviderRegistry$builtInProviders$40(null), new ProviderRegistry$builtInProviders$41(null), function521, 36, defaultConstructorMarker), new ProviderDef("p_primevideo", "Prime Video", false, new ProviderRegistry$builtInProviders$42(null), new ProviderRegistry$builtInProviders$43(null), null, 36, null), new ProviderDef("p_disney", "Hotstar", false, new ProviderRegistry$builtInProviders$44(null), new ProviderRegistry$builtInProviders$45(null), null, 36, null), new ProviderDef("p_bollywood", "Gramcinema", false, new ProviderRegistry$builtInProviders$46(null), new ProviderRegistry$builtInProviders$47(null), null, 36, null), new ProviderDef("p_flixindia", "FlixIndia", false, new ProviderRegistry$builtInProviders$48(null), new ProviderRegistry$builtInProviders$49(null), null, 36, null), new ProviderDef("p_vegamovies", "VegaMovies", false, new ProviderRegistry$builtInProviders$50(null), new ProviderRegistry$builtInProviders$51(null), function522, 36, null), new ProviderDef("p_rogmovies", "RogMovies", false, new ProviderRegistry$builtInProviders$52(null), function522, null, 52, null), new ProviderDef("p_bollyflix", "Bollyflix", false, new ProviderRegistry$builtInProviders$53(null), new ProviderRegistry$builtInProviders$54(null), function523, 36, null), new ProviderDef("p_topmovies", "TopMovies", false, new ProviderRegistry$builtInProviders$55(null), function523, null, 52, function521), new ProviderDef("p_moviesmod", "Moviesmod", false, new ProviderRegistry$builtInProviders$56(null), new ProviderRegistry$builtInProviders$57(null), null, 36, null), new ProviderDef("p_movies4u", "Movies4u", false, new ProviderRegistry$builtInProviders$58(null), new ProviderRegistry$builtInProviders$59(null), function524, 36, defaultConstructorMarker), new ProviderDef("p_dudefilms", "Dudefilms", false, new ProviderRegistry$builtInProviders$60(null), new ProviderRegistry$builtInProviders$61(null), null, 36, null), new ProviderDef("p_uhdmovies", "UHDMovies", false, new ProviderRegistry$builtInProviders$62(null), new ProviderRegistry$builtInProviders$63(null), null, 36, null), new ProviderDef("p_moviesdrive", "MoviesDrive", false, new ProviderRegistry$builtInProviders$64(null), new ProviderRegistry$builtInProviders$65(null), null, 36, null), new ProviderDef("p_hindmoviez", "Hindmoviez", false, new ProviderRegistry$builtInProviders$66(null), new ProviderRegistry$builtInProviders$67(null), null, 36, null), new ProviderDef("p_4khdhub", "4KHDHub", false, new ProviderRegistry$builtInProviders$68(null), new ProviderRegistry$builtInProviders$69(null), null, 36, null), new ProviderDef("p_primesrc", "PrimeSrc", false, new ProviderRegistry$builtInProviders$70(null), new ProviderRegistry$builtInProviders$71(null), function525, 36, null), new ProviderDef("p_projectfreetv", "ProjectFreeTV", false, new ProviderRegistry$builtInProviders$72(null), function525, function526, 52, null), new ProviderDef("p_levidia", "Levidia", false, new ProviderRegistry$builtInProviders$73(null), function526, null, 52, function524), new ProviderDef("p_dahmermovies", "DahmerMovies", false, new ProviderRegistry$builtInProviders$74(null), new ProviderRegistry$builtInProviders$75(null), function527, 36, null), new ProviderDef("p_m4ufree", "M4ufree", false, new ProviderRegistry$builtInProviders$76(null), function527, function528, 52, defaultConstructorMarker), new ProviderDef("p_multimovies", "Multimovies", false, new ProviderRegistry$builtInProviders$77(null), new ProviderRegistry$builtInProviders$78(null), null, 36, null), new ProviderDef("p_protonmovies", "Protonmovies", false, new ProviderRegistry$builtInProviders$79(null), new ProviderRegistry$builtInProviders$80(null), function529, 36, null), new ProviderDef("p_akwam", "Akwam", false, new ProviderRegistry$builtInProviders$81(null), function529, function530, 52, null), new ProviderDef("p_rtally", "Rtally", false, new ProviderRegistry$builtInProviders$82(null), function530, function531, 52, null), new ProviderDef("p_asiaflix", "Asiaflix", false, new ProviderRegistry$builtInProviders$83(null), function531, function532, 52, null), new ProviderDef("p_skymovies", "SkyMovies", false, new ProviderRegistry$builtInProviders$84(null), function532, function533, 52, null), new ProviderDef("p_hdmovie2", "HDMovie2", false, new ProviderRegistry$builtInProviders$85(null), function533, function534, 52, function527), new ProviderDef("p_mostraguarda", "Mostraguarda", false, new ProviderRegistry$builtInProviders$86(null), function534, function535, 52, function528), new ProviderDef("p_vidsrccc", "VidsrcCC", false, new ProviderRegistry$builtInProviders$87(null), function535, function536, 52, null), new ProviderDef("p_autoembed", "AutoEmbed", false, new ProviderRegistry$builtInProviders$88(null), function536, function537, 52, defaultConstructorMarker), new ProviderDef("p_kisskh", "KissKH", false, new ProviderRegistry$builtInProviders$89(null), null, function538, 52, null), new ProviderDef("p_onetouchtv", "Onetouchtv", false, new ProviderRegistry$builtInProviders$90(null), function538, null, 52, null), new ProviderDef("p_toonstream", "Toonstream", false, new ProviderRegistry$builtInProviders$91(null), new ProviderRegistry$builtInProviders$92(null), function539, 36, null), new ProviderDef("p_animepahe", "AnimePahe", false, null, function539, new ProviderRegistry$builtInProviders$93(null), 28, null), new ProviderDef("p_animekai", "Animekai", false, function539, function540, new ProviderRegistry$builtInProviders$94(null), 28, null), new ProviderDef("p_allanime", "AllAnime", false, function540, new ProviderRegistry$builtInProviders$95(null), new ProviderRegistry$builtInProviders$96(null), 12, null), new ProviderDef("p_tokyoinsider", "TokyoInsider", false, null, new ProviderRegistry$builtInProviders$97(null), new ProviderRegistry$builtInProviders$98(null), 12, function536), new ProviderDef("p_anizone", "Anizone", false, null, new ProviderRegistry$builtInProviders$99(null), new ProviderRegistry$builtInProviders$100(null), 12, function537), new ProviderDef("p_kuudere", "Kuudere", false, null, new ProviderRegistry$builtInProviders$101(null), null, 44, null), new ProviderDef("p_animes", "Animes*", false, null, new ProviderRegistry$builtInProviders$102(null), null, 44, defaultConstructorMarker), new ProviderDef("p_gojo", "Animetsu", false, null, new ProviderRegistry$builtInProviders$103(null), new ProviderRegistry$builtInProviders$104(null), 12, null), new ProviderDef("p_animekizz", "Animekizz", false, null, new ProviderRegistry$builtInProviders$105(null), new ProviderRegistry$builtInProviders$106(null), 12, null), new ProviderDef("p_sudatchi", "Sudatchi", false, null, new ProviderRegistry$builtInProviders$107(null), new ProviderRegistry$builtInProviders$108(null), 12, null)});
    }

    @NotNull
    public final List<ProviderDef> getBuiltInProviders() {
        return builtInProviders;
    }

    @NotNull
    public final List<String> getKeys() {
        Iterable $this$map$iv = builtInProviders;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ProviderDef it = (ProviderDef) item$iv$iv;
            destination$iv$iv.add(it.getKey());
        }
        return (List) destination$iv$iv;
    }

    @NotNull
    public final Map<String, String> getNamesMap() {
        Iterable $this$associate$iv = builtInProviders;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            ProviderDef it = (ProviderDef) element$iv$iv;
            Pair pair = TuplesKt.to(it.getKey(), it.getDisplayName());
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv;
    }

    @NotNull
    public final Set<String> getTorrentKeys() {
        Iterable $this$filter$iv = builtInProviders;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ProviderDef it = (ProviderDef) element$iv$iv;
            if (it.isTorrent()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ProviderDef it2 = (ProviderDef) item$iv$iv;
            destination$iv$iv2.add(it2.getKey());
        }
        return CollectionsKt.toSet((List) destination$iv$iv2);
    }
}
