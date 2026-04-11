package w4;

import android.content.Context;
import android.content.Intent;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ka.f f13904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w.b f13905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f13906e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r f13907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f13908h;
    public final Executor i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Intent f13909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f13910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f13911l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set f13912m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f13913n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final File f13914o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Callable f13915p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f13916q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f13917r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f13918s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c5.b f13919t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final vd.h f13920u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f13921v;

    public a(Context context, String str, ka.f fVar, w.b bVar, List list, boolean z10, r rVar, Executor executor, Executor executor2, Intent intent, boolean z11, boolean z12, Set set, String str2, File file, Callable callable, List list2, List list3, boolean z13, c5.b bVar2, vd.h hVar) {
        ge.i.e(context, "context");
        ge.i.e(bVar, "migrationContainer");
        ge.i.e(executor, "queryExecutor");
        ge.i.e(executor2, "transactionExecutor");
        ge.i.e(list2, "typeConverters");
        ge.i.e(list3, "autoMigrationSpecs");
        this.f13902a = context;
        this.f13903b = str;
        this.f13904c = fVar;
        this.f13905d = bVar;
        this.f13906e = list;
        this.f = z10;
        this.f13907g = rVar;
        this.f13908h = executor;
        this.i = executor2;
        this.f13909j = intent;
        this.f13910k = z11;
        this.f13911l = z12;
        this.f13912m = set;
        this.f13913n = str2;
        this.f13914o = file;
        this.f13915p = callable;
        this.f13916q = list2;
        this.f13917r = list3;
        this.f13918s = z13;
        this.f13919t = bVar2;
        this.f13920u = hVar;
        this.f13921v = true;
    }
}
