package r4;

import android.content.Context;
import android.content.Intent;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pa.b f11406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a1 f11407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f11408e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r f11409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f11410h;
    public final Executor i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Intent f11411j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f11412k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f11413l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set f11414m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f11415n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final File f11416o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Callable f11417p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f11418q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f11419r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f11420s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final y4.b f11421t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final rd.h f11422u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f11423v;

    public a(Context context, String str, pa.b bVar, a1 a1Var, List list, boolean z2, r rVar, Executor executor, Executor executor2, Intent intent, boolean z10, boolean z11, Set set, String str2, File file, Callable callable, List list2, List list3, boolean z12, y4.b bVar2, rd.h hVar) {
        be.h.e(context, "context");
        be.h.e(a1Var, "migrationContainer");
        be.h.e(executor, "queryExecutor");
        be.h.e(executor2, "transactionExecutor");
        be.h.e(list2, "typeConverters");
        be.h.e(list3, "autoMigrationSpecs");
        this.f11404a = context;
        this.f11405b = str;
        this.f11406c = bVar;
        this.f11407d = a1Var;
        this.f11408e = list;
        this.f = z2;
        this.f11409g = rVar;
        this.f11410h = executor;
        this.i = executor2;
        this.f11411j = intent;
        this.f11412k = z10;
        this.f11413l = z11;
        this.f11414m = set;
        this.f11415n = str2;
        this.f11416o = file;
        this.f11417p = callable;
        this.f11418q = list2;
        this.f11419r = list3;
        this.f11420s = z12;
        this.f11421t = bVar2;
        this.f11422u = hVar;
        this.f11423v = true;
    }
}
