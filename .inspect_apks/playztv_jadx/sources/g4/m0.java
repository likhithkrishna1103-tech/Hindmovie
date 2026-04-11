package g4;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.util.Log;
import android.util.SparseBooleanArray;
import com.playz.tv.activities.PlayerActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m0 extends h4.r {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f5114w;
    public final ub.o f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b0 f5115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h4.e0 f5116h;
    public final k0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final cc.q0 f5117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h4.z f5118k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c2.e f5119l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ComponentName f5120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f5121n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile long f5122o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public k0 f5123p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5124q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Bundle f5125r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public aa.j0 f5126s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public aa.j0 f5127t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public n1 f5128u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public p1.s0 f5129v;

    static {
        f5114w = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public m0(g4.b0 r10, android.net.Uri r11, android.os.Handler r12, android.os.Bundle r13, aa.j0 r14, aa.j0 r15, g4.n1 r16, p1.s0 r17, android.os.Bundle r18) {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.m0.<init>(g4.b0, android.net.Uri, android.os.Handler, android.os.Bundle, aa.j0, aa.j0, g4.n1, p1.s0, android.os.Bundle):void");
    }

    public static void D(h4.z zVar, ArrayList arrayList) {
        int i = 0;
        if (arrayList != null) {
            zVar.getClass();
            HashSet hashSet = new HashSet();
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                long j5 = ((h4.w) obj).f5859v;
                if (hashSet.contains(Long.valueOf(j5))) {
                    Log.e("MediaSessionCompat", "Found duplicate queue id: " + j5, new IllegalArgumentException("id of each queue item should be unique"));
                }
                hashSet.add(Long.valueOf(j5));
            }
        }
        h4.t tVar = (h4.t) zVar.f5867v;
        MediaSession mediaSession = tVar.f5847a;
        tVar.f5853h = arrayList;
        if (arrayList == null) {
            mediaSession.setQueue(null);
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj2 = arrayList.get(i);
            i++;
            h4.w wVar = (h4.w) obj2;
            MediaSession.QueueItem queueItem = wVar.f5860w;
            if (queueItem == null) {
                MediaSession.QueueItem queueItem2 = new MediaSession.QueueItem(wVar.f5858u.a(), wVar.f5859v);
                wVar.f5860w = queueItem2;
                queueItem = queueItem2;
            }
            arrayList2.add(queueItem);
        }
        mediaSession.setQueue(arrayList2);
    }

    public static void E(h4.z zVar, h4.o oVar) {
        h4.t tVar = (h4.t) zVar.f5867v;
        tVar.i = oVar;
        MediaSession mediaSession = tVar.f5847a;
        Bundle bundle = oVar.f5837u;
        if (oVar.f5838v == null) {
            MediaMetadata.Builder builder = new MediaMetadata.Builder();
            for (String str : bundle.keySet()) {
                Integer num = (Integer) h4.o.f5835w.get(str);
                if (num == null) {
                    num = -1;
                }
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    builder.putLong(str, bundle.getLong(str));
                } else if (iIntValue == 1) {
                    builder.putText(str, bundle.getString(str));
                } else if (iIntValue == 2) {
                    builder.putBitmap(str, (Bitmap) bundle.getParcelable(str));
                } else if (iIntValue != 3) {
                    Object obj = bundle.get(str);
                    if (obj == null || (obj instanceof CharSequence)) {
                        builder.putText(str, (CharSequence) obj);
                    } else if (obj instanceof Long) {
                        builder.putLong(str, ((Long) obj).longValue());
                    }
                } else {
                    builder.putRating(str, (Rating) bundle.getParcelable(str));
                }
            }
            oVar.f5838v = builder.build();
        }
        mediaSession.setMetadata(oVar.f5838v);
    }

    public static p1.g0 F(String str, Uri uri, String str2, Bundle bundle) {
        p1.w wVar = new p1.w();
        aa.h0 h0Var = aa.j0.f690v;
        aa.c1 c1Var = aa.c1.f650y;
        List list = Collections.EMPTY_LIST;
        aa.c1 c1Var2 = aa.c1.f650y;
        e2.t tVar = new e2.t();
        p1.d0 d0Var = p1.d0.f9694d;
        if (str == null) {
            str = "";
        }
        String str3 = str;
        kc.b bVar = new kc.b(9);
        bVar.f7620v = uri;
        bVar.f7621w = str2;
        bVar.f7622x = bundle;
        return new p1.g0(str3, new p1.y(wVar), null, new p1.b0(tVar), p1.j0.K, new p1.d0(bVar));
    }

    public static ComponentName J(PlayerActivity playerActivity, String str) {
        PackageManager packageManager = playerActivity.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(playerActivity.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            return null;
        }
        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
        return new ComponentName(serviceInfo.packageName, serviceInfo.name);
    }

    @Override // h4.r
    public final void A(long j5) {
        if (j5 < 0) {
            return;
        }
        H(10, new d0(this, j5, 0), ((h4.t) this.f5118k.f5867v).c(), true);
    }

    @Override // h4.r
    public final void B() {
        H(3, new e0(this, 6), ((h4.t) this.f5118k.f5867v).c(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final h4.h0 G(g4.j1 r31) {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.m0.G(g4.j1):h4.h0");
    }

    public final void H(final int i, final l0 l0Var, final h4.b0 b0Var, final boolean z2) {
        b0 b0Var2 = this.f5115g;
        if (b0Var2.j()) {
            return;
        }
        if (b0Var != null) {
            s1.b0.S(b0Var2.f4965l, new Runnable() { // from class: g4.i0
                @Override // java.lang.Runnable
                public final void run() {
                    l0 l0Var2 = l0Var;
                    m0 m0Var = this.f5085u;
                    b0 b0Var3 = m0Var.f5115g;
                    if (b0Var3.j()) {
                        return;
                    }
                    boolean zIsActive = ((h4.t) m0Var.f5118k.f5867v).f5847a.isActive();
                    int i10 = i;
                    h4.b0 b0Var4 = b0Var;
                    if (!zIsActive) {
                        s1.b.p("MediaSessionLegacyStub", "Ignore incoming player command before initialization. command=" + i10 + ", pid=" + b0Var4.f5792a.f5794b);
                        return;
                    }
                    s sVarL = m0Var.L(b0Var4);
                    if (!m0Var.f.G(sVarL, i10)) {
                        if (i10 != 1 || b0Var3.f4973t.C()) {
                            return;
                        }
                        s1.b.p("MediaSessionLegacyStub", "Calling play() omitted due to COMMAND_PLAY_PAUSE not being available. If this play command has started the service for instance for playback resumption, this may prevent the service from being started into the foreground.");
                        return;
                    }
                    q9.e eVar = b0Var3.f4960e;
                    b0Var3.s(sVarL);
                    eVar.getClass();
                    try {
                        l0Var2.d(sVarL);
                    } catch (RemoteException e10) {
                        s1.b.q("MediaSessionLegacyStub", "Exception in " + sVarL, e10);
                    }
                    if (z2) {
                        new SparseBooleanArray().append(i10, true);
                        b0Var3.p(sVarL);
                    }
                }
            });
            return;
        }
        s1.b.f("MediaSessionLegacyStub", "RemoteUserInfo is null, ignoring command=" + i);
    }

    public final void I(m1 m1Var, int i, l0 l0Var, h4.b0 b0Var) {
        if (b0Var != null) {
            s1.b0.S(this.f5115g.f4965l, new a2.o1(this, m1Var, i, b0Var, l0Var));
            return;
        }
        StringBuilder sb2 = new StringBuilder("RemoteUserInfo is null, ignoring command=");
        Object objValueOf = m1Var;
        if (m1Var == null) {
            objValueOf = Integer.valueOf(i);
        }
        sb2.append(objValueOf);
        s1.b.f("MediaSessionLegacyStub", sb2.toString());
    }

    public final void K(p1.g0 g0Var, boolean z2) {
        H(31, new h0(this, g0Var, z2), ((h4.t) this.f5118k.f5867v).c(), false);
    }

    public final s L(h4.b0 b0Var) {
        s sVarX = this.f.x(b0Var);
        if (sVarX == null) {
            s sVar = new s(b0Var, 0, 0, this.f5116h.b(b0Var), new j0(b0Var), Bundle.EMPTY);
            q qVarM = this.f5115g.m(sVar);
            this.f.b(b0Var, sVar, qVarM.f5179a, qVarM.f5180b);
            b0 b0Var2 = this.f5115g;
            if (!b0Var2.f4977x || !b0.k(sVar)) {
                b0Var2.f4960e.getClass();
            }
            sVarX = sVar;
        }
        cc.q0 q0Var = this.f5117j;
        long j5 = this.f5122o;
        q0Var.removeMessages(1001, sVarX);
        q0Var.sendMessageDelayed(q0Var.obtainMessage(1001, sVarX), j5);
        return sVarX;
    }

    public final void M() {
        aa.j0 j0Var = this.f5127t;
        int i = a.f4948a;
        aa.q.c("initialCapacity", 4);
        Object[] objArr = new Object[4];
        if (j0Var.size() > 0) {
            j0Var.get(0).getClass();
            throw new ClassCastException();
        }
        aa.c1 c1VarA = a.a(aa.j0.l(0, objArr));
        this.f5126s = c1VarA;
        if (c1VarA.size() > 0) {
            c1VarA.get(0);
            throw new ClassCastException();
        }
        Bundle bundle = this.f5125r;
        bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", true);
        aa.j0 j0Var2 = this.f5126s;
        if (j0Var2.size() <= 0) {
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", true);
        } else {
            j0Var2.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final void N(j1 j1Var) {
        s1.b0.S(this.f5115g.f4965l, new f0(this, j1Var, 1));
    }

    @Override // h4.r
    public final void b(h4.n nVar) {
        if (nVar != null) {
            H(20, new a2.h0(this, -1, nVar), ((h4.t) this.f5118k.f5867v).c(), false);
        }
    }

    @Override // h4.r
    public final void c(h4.n nVar, int i) {
        if (nVar != null) {
            if (i == -1 || i >= 0) {
                H(20, new a2.h0(this, i, nVar), ((h4.t) this.f5118k.f5867v).c(), false);
            }
        }
    }

    @Override // h4.r
    public final void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (str.equals("androidx.media3.session.SESSION_COMMAND_MEDIA3_PLAY_REQUEST")) {
            return;
        }
        if (!str.equals("androidx.media3.session.SESSION_COMMAND_REQUEST_SESSION3_TOKEN") || resultReceiver == null) {
            m1 m1Var = new m1(str, Bundle.EMPTY);
            I(m1Var, 0, new dd.e(this, m1Var, bundle, resultReceiver), ((h4.t) this.f5118k.f5867v).c());
            return;
        }
        r1 r1Var = this.f5115g.f4963j;
        r1Var.getClass();
        String str2 = r1.f5196b;
        Bundle bundle2 = new Bundle();
        s1 s1Var = r1Var.f5198a;
        if (s1Var != null) {
            bundle2.putInt(str2, 0);
        } else {
            bundle2.putInt(str2, 1);
        }
        String str3 = r1.f5197c;
        s1Var.getClass();
        Bundle bundle3 = new Bundle();
        bundle3.putInt(s1.i, s1Var.f5214a);
        bundle3.putInt(s1.f5205j, 0);
        bundle3.putInt(s1.f5206k, s1Var.f5215b);
        bundle3.putString(s1.f5207l, s1Var.f5217d);
        bundle3.putString(s1.f5208m, s1Var.f5218e);
        bundle3.putBinder(s1.f5210o, s1Var.f);
        bundle3.putParcelable(s1.f5209n, null);
        bundle3.putBundle(s1.f5211p, s1Var.f5219g);
        bundle3.putInt(s1.f5212q, s1Var.f5216c);
        MediaSession.Token token = s1Var.f5220h;
        if (token != null) {
            bundle3.putParcelable(s1.f5213r, token);
        }
        bundle2.putBundle(str3, bundle3);
        resultReceiver.send(0, bundle2);
    }

    @Override // h4.r
    public final void e(String str, Bundle bundle) {
        if (str.equals("androidx.media3.session.SESSION_COMMAND_MEDIA3_PLAY_REQUEST")) {
            return;
        }
        m1 m1Var = new m1(str, Bundle.EMPTY);
        I(m1Var, 0, new b2.b(this, m1Var, bundle), ((h4.t) this.f5118k.f5867v).c());
    }

    @Override // h4.r
    public final void f() {
        H(12, new e0(this, 4), ((h4.t) this.f5118k.f5867v).c(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00da  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // h4.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.content.Intent r13) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.m0.g(android.content.Intent):boolean");
    }

    @Override // h4.r
    public final void h() {
        H(1, new e0(this, 11), ((h4.t) this.f5118k.f5867v).c(), true);
    }

    @Override // h4.r
    public final void i() {
        H(1, new e0(this, 10), ((h4.t) this.f5118k.f5867v).c(), false);
    }

    @Override // h4.r
    public final void j(String str, Bundle bundle) {
        K(F(str, null, null, bundle), true);
    }

    @Override // h4.r
    public final void k(String str, Bundle bundle) {
        K(F(null, null, str, bundle), true);
    }

    @Override // h4.r
    public final void l(Uri uri, Bundle bundle) {
        K(F(null, uri, null, bundle), true);
    }

    @Override // h4.r
    public final void m() {
        H(2, new e0(this, 5), ((h4.t) this.f5118k.f5867v).c(), true);
    }

    @Override // h4.r
    public final void n(String str, Bundle bundle) {
        K(F(str, null, null, bundle), false);
    }

    @Override // h4.r
    public final void o(String str, Bundle bundle) {
        K(F(null, null, str, bundle), false);
    }

    @Override // h4.r
    public final void p(Uri uri, Bundle bundle) {
        K(F(null, uri, null, bundle), false);
    }

    @Override // h4.r
    public final void q(h4.n nVar) {
        if (nVar == null) {
            return;
        }
        H(20, new b2.b(this, 4, nVar), ((h4.t) this.f5118k.f5867v).c(), true);
    }

    @Override // h4.r
    public final void r() {
        H(11, new e0(this, 3), ((h4.t) this.f5118k.f5867v).c(), true);
    }

    @Override // h4.r
    public final void s(long j5) {
        H(5, new d0(this, j5, 1), ((h4.t) this.f5118k.f5867v).c(), true);
    }

    @Override // h4.r
    public final void t(final float f) {
        if (f <= 0.0f) {
            return;
        }
        H(13, new l0() { // from class: g4.c0
            @Override // g4.l0
            public final void d(s sVar) {
                this.f4984u.f5115g.f4973t.i(f);
            }
        }, ((h4.t) this.f5118k.f5867v).c(), true);
    }

    @Override // h4.r
    public final void u(h4.i0 i0Var) {
        v(i0Var);
    }

    @Override // h4.r
    public final void v(h4.i0 i0Var) {
        p1.x0 x0VarC = l.c(i0Var);
        if (x0VarC != null) {
            I(null, 40010, new e0(this, x0VarC), ((h4.t) this.f5118k.f5867v).c());
            return;
        }
        s1.b.p("MediaSessionLegacyStub", "Ignoring invalid RatingCompat " + i0Var);
    }

    @Override // h4.r
    public final void w(int i) {
        H(15, new g0(this, i, 0), ((h4.t) this.f5118k.f5867v).c(), true);
    }

    @Override // h4.r
    public final void x(int i) {
        H(14, new g0(this, i, 1), ((h4.t) this.f5118k.f5867v).c(), true);
    }

    @Override // h4.r
    public final void y() {
        boolean zE0 = this.f5115g.f4973t.e0(9);
        h4.z zVar = this.f5118k;
        if (zE0) {
            H(9, new e0(this, 8), ((h4.t) zVar.f5867v).c(), true);
        } else {
            H(8, new e0(this, 9), ((h4.t) zVar.f5867v).c(), true);
        }
    }

    @Override // h4.r
    public final void z() {
        boolean zE0 = this.f5115g.f4973t.e0(7);
        h4.z zVar = this.f5118k;
        if (zE0) {
            H(7, new e0(this, 1), ((h4.t) zVar.f5867v).c(), true);
        } else {
            H(6, new e0(this, 2), ((h4.t) zVar.f5867v).c(), true);
        }
    }
}
