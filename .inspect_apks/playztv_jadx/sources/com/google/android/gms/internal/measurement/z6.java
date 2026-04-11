package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z6 implements a7 {
    public static final r4 A;
    public static final r4 B;
    public static final r4 C;
    public static final r4 D;
    public static final r4 E;
    public static final r4 F;
    public static final r4 G;
    public static final r4 H;
    public static final r4 I;
    public static final r4 J;
    public static final r4 K;
    public static final r4 L;
    public static final r4 M;
    public static final r4 N;
    public static final r4 O;
    public static final r4 P;
    public static final r4 Q;
    public static final r4 R;
    public static final r4 S;
    public static final r4 T;
    public static final r4 U;
    public static final r4 V;
    public static final r4 W;
    public static final r4 X;
    public static final r4 Y;
    public static final r4 Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r4 f3261a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final r4 f3262a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r4 f3263b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final r4 f3264b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r4 f3265c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final r4 f3266c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r4 f3267d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final r4 f3268d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final r4 f3269e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final r4 f3270e0;
    public static final r4 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final r4 f3271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final r4 f3272h;
    public static final r4 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final r4 f3273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final r4 f3274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final r4 f3275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final r4 f3276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final r4 f3277n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final r4 f3278o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final r4 f3279p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final r4 f3280q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final r4 f3281r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final r4 f3282s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final r4 f3283t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final r4 f3284u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final r4 f3285v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final r4 f3286w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final r4 f3287x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final r4 f3288y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final r4 f3289z;

    static {
        a2.c cVar = new a2.c(o4.a("com.google.android.gms.measurement"), "", "", true, true);
        f3261a = cVar.l("measurement.ad_id_cache_time", 10000L);
        f3263b = cVar.l("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L);
        f3265c = cVar.n("measurement.config.bundle_for_all_apps_on_backgrounded", true);
        f3267d = cVar.l("measurement.max_bundles_per_iteration", 100L);
        f3269e = cVar.l("measurement.config.cache_time", 86400000L);
        cVar.m("measurement.log_tag", "FA");
        f = cVar.m("measurement.config.url_authority", "app-measurement.com");
        f3271g = cVar.m("measurement.config.url_scheme", "https");
        f3272h = cVar.l("measurement.upload.debug_upload_interval", 1000L);
        i = cVar.l("measurement.session.engagement_interval", 3600000L);
        f3273j = cVar.m("measurement.rb.attribution.event_params", "value|currency");
        cVar.l("measurement.id.rb.attribution.app_allowlist", 0L);
        f3274k = cVar.l("measurement.upload.google_signal_max_queue_time", 605000L);
        f3275l = cVar.m("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d");
        f3276m = cVar.l("measurement.lifetimevalue.max_currency_tracked", 4L);
        f3277n = cVar.l("measurement.dma_consent.max_daily_dcu_realtime_events", 1L);
        f3278o = cVar.l("measurement.upload.max_event_parameter_value_length", 500L);
        f3279p = cVar.l("measurement.store.max_stored_events_per_app", 100000L);
        f3280q = cVar.l("measurement.experiment.max_ids", 50L);
        f3281r = cVar.l("measurement.audience.filter_result_max_count", 200L);
        f3282s = cVar.l("measurement.upload.max_item_scoped_custom_parameters", 27L);
        f3283t = cVar.l("measurement.rb.max_trigger_registrations_per_day", 0L);
        f3284u = cVar.l("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0L);
        f3285v = cVar.l("measurement.rb.attribution.client.min_ad_services_version", 7L);
        f3286w = cVar.l("measurement.alarm_manager.minimum_interval", 60000L);
        f3287x = cVar.l("measurement.upload.minimum_delay", 500L);
        f3288y = cVar.l("measurement.monitoring.sample_period_millis", 86400000L);
        f3289z = cVar.n("measurement.config.notify_trigger_uris_on_backgrounded", true);
        A = cVar.m("measurement.rb.attribution.app_allowlist", "com.labpixies.flood,com.sofascore.results,games.spearmint.triplecrush,com.block.juggle,io.supercent.linkedcubic,com.cdtg.gunsound,com.corestudios.storemanagementidle,com.cdgames.fidget3d,io.supercent.burgeridle,io.supercent.pizzaidle,jp.ne.ibis.ibispaintx.app,com.dencreak.dlcalculator,com.ebay.kleinanzeigen,de.wetteronline.wetterapp,com.game.shape.shift,com.champion.cubes,bubbleshooter.orig,com.wolt.android,com.master.hotelmaster,com.games.bus.arrival,com.playstrom.dop2,com.huuuge.casino.slots,com.ig.spider.fighting,com.jura.coloring.page,com.rikkogame.ragdoll2,com.ludo.king,com.sigma.prank.sound.haircut,com.crazy.block.robo.monster.cliffs.craft,com.fugo.wow,com.maps.locator.gps.gpstracker.phone,com.gamovation.tileclub,com.pronetis.ironball2,com.meesho.supply,pdf.pdfreader.viewer.editor.free,com.dino.race.master,com.ig.moto.racing,ai.photo.enhancer.photoclear,com.duolingo,com.candle.magic_piano,com.free.vpn.super.hotspot.open,sg.bigo.live,com.cdg.tictactoe,com.zhiliaoapp.musically.go,com.wildspike.wormszone,com.mast.status.video.edit,com.vyroai.photoeditorone,com.pujiagames.deeeersimulator,com.superbinogo.jungleboyadventure,com.trustedapp.pdfreaderpdfviewer,com.artimind.aiart.artgenerator.artavatar,de.cellular.ottohybrid,com.zeptolab.cats.google,in.crossy.daily_crossword");
        B = cVar.l("measurement.upload.realtime_upload_interval", 10000L);
        C = cVar.l("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        cVar.l("measurement.config.cache_time.service", 3600000L);
        D = cVar.l("measurement.service_client.idle_disconnect_millis", 5000L);
        cVar.m("measurement.log_tag.service", "FA-SVC");
        E = cVar.m("measurement.sgtm.app_allowlist", "de.zalando.mobile.internal,de.zalando.mobile.internal.debug,de.zalando.lounge.dev,grit.storytel.app,com.rbc.mobile.android,com.rbc.mobile.android,com.dylvian.mango.activities,com.home24.android,com.home24.android.staging,se.lf.mobile.android,se.lf.mobile.android.beta,se.lf.mobile.android.rc,se.lf.mobile.android.test,se.lf.mobile.android.test.debug,com.boots.flagship.android,com.boots.flagshiproi.android,de.zalando.mobile,com.trivago,com.getyourguide.android,es.mobail.meliarewards,se.nansen.coop.debug,se.nansen.coop,se.coop.coop.qa,com.booking,com.google.firebaseengage,com.mse.mseapp.dev,com.mse.mseapp,pl.eobuwie.eobuwieapp,br.com.eventim.mobile.app.Android,ch.ticketcorner.mobile.app.Android,de.eventim.mobile.app.Android,dk.billetlugen.mobile.app.Android,nl.eventim.mobile.app.Android,com.asos.app,com.blueshieldca.prod,dk.magnetix.tivoliapp,matas.matas.internal,nl.omoda,com.thetrainline,com.simo.androidtest,de.aboutyou.mobile.app,com.hometogo,de.casamundo.casamundomobile,it.casevacanz,eu.coolblue.shop,com.stihl.app,com.indeed.android.jobsearch,com.homeretailgroup.argos.android,com.dylvian.mango.activities.pre,se.nansen.coop.qa");
        F = cVar.l("measurement.upload.stale_data_deletion_interval", 86400000L);
        G = cVar.m("measurement.rb.attribution.uri_authority", "google-analytics.com");
        H = cVar.l("measurement.rb.attribution.max_queue_time", 1209600000L);
        I = cVar.m("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        J = cVar.m("measurement.rb.attribution.query_parameters_to_remove", "");
        K = cVar.m("measurement.rb.attribution.uri_scheme", "https");
        L = cVar.l("measurement.sdk.attribution.cache.ttl", 604800000L);
        M = cVar.l("measurement.redaction.app_instance_id.ttl", 7200000L);
        N = cVar.l("measurement.upload.backoff_period", 43200000L);
        O = cVar.l("measurement.upload.initial_upload_delay_time", 15000L);
        P = cVar.l("measurement.upload.interval", 3600000L);
        Q = cVar.l("measurement.upload.max_bundle_size", 65536L);
        R = cVar.l("measurement.upload.max_bundles", 100L);
        S = cVar.l("measurement.upload.max_conversions_per_day", 500L);
        T = cVar.l("measurement.upload.max_error_events_per_day", 1000L);
        U = cVar.l("measurement.upload.max_events_per_bundle", 1000L);
        V = cVar.l("measurement.upload.max_events_per_day", 100000L);
        W = cVar.l("measurement.upload.max_public_events_per_day", 50000L);
        X = cVar.l("measurement.upload.max_queue_time", 518400000L);
        Y = cVar.l("measurement.upload.max_realtime_events_per_day", 10L);
        Z = cVar.l("measurement.upload.max_batch_size", 65536L);
        f3262a0 = cVar.l("measurement.upload.retry_count", 6L);
        f3264b0 = cVar.l("measurement.upload.retry_time", 1800000L);
        f3266c0 = cVar.m("measurement.upload.url", "https://app-measurement.com/a");
        f3268d0 = cVar.l("measurement.upload.window_interval", 3600000L);
        f3270e0 = cVar.m("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot");
    }
}
