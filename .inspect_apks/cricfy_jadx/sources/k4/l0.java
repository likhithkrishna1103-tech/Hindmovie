package k4;

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
import app.cricfy.tv.activities.PlayerActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends l4.u {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f7059w;
    public final b6.f f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b0 f7060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l4.h0 f7061h;
    public final b7.d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h.d f7062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l4.c0 f7063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bumptech.glide.manager.r f7064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ComponentName f7065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f7066n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile long f7067o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b7.d f7068p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7069q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Bundle f7070r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ua.i0 f7071s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ua.i0 f7072t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public l1 f7073u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public v1.s0 f7074v;

    static {
        f7059w = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
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
    public l0(k4.b0 r10, android.net.Uri r11, android.os.Handler r12, android.os.Bundle r13, ua.i0 r14, ua.i0 r15, k4.l1 r16, v1.s0 r17, android.os.Bundle r18) {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.l0.<init>(k4.b0, android.net.Uri, android.os.Handler, android.os.Bundle, ua.i0, ua.i0, k4.l1, v1.s0, android.os.Bundle):void");
    }

    public static void D(l4.c0 c0Var, ArrayList arrayList) {
        int i = 0;
        if (arrayList != null) {
            c0Var.getClass();
            HashSet hashSet = new HashSet();
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                long j4 = ((l4.z) obj).f7777w;
                if (hashSet.contains(Long.valueOf(j4))) {
                    Log.e("MediaSessionCompat", "Found duplicate queue id: " + j4, new IllegalArgumentException("id of each queue item should be unique"));
                }
                hashSet.add(Long.valueOf(j4));
            }
        }
        l4.w wVar = (l4.w) c0Var.f7705w;
        MediaSession mediaSession = wVar.f7765a;
        wVar.f7771h = arrayList;
        if (arrayList == null) {
            mediaSession.setQueue(null);
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj2 = arrayList.get(i);
            i++;
            l4.z zVar = (l4.z) obj2;
            MediaSession.QueueItem queueItem = zVar.f7778x;
            if (queueItem == null) {
                MediaSession.QueueItem queueItem2 = new MediaSession.QueueItem(zVar.f7776v.a(), zVar.f7777w);
                zVar.f7778x = queueItem2;
                queueItem = queueItem2;
            }
            arrayList2.add(queueItem);
        }
        mediaSession.setQueue(arrayList2);
    }

    public static void E(l4.c0 c0Var, l4.r rVar) {
        l4.w wVar = (l4.w) c0Var.f7705w;
        wVar.i = rVar;
        MediaSession mediaSession = wVar.f7765a;
        Bundle bundle = rVar.f7755v;
        if (rVar.f7756w == null) {
            MediaMetadata.Builder builder = new MediaMetadata.Builder();
            for (String str : bundle.keySet()) {
                Integer num = (Integer) l4.r.f7753x.get(str);
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
            rVar.f7756w = builder.build();
        }
        mediaSession.setMetadata(rVar.f7756w);
    }

    public static v1.g0 F(String str, Uri uri, String str2, Bundle bundle) {
        v1.v vVar = new v1.v();
        ua.g0 g0Var = ua.i0.f12341w;
        ua.z0 z0Var = ua.z0.f12413z;
        List list = Collections.EMPTY_LIST;
        ua.z0 z0Var2 = ua.z0.f12413z;
        k2.t tVar = new k2.t();
        v1.d0 d0Var = v1.d0.f12622d;
        if (str == null) {
            str = "";
        }
        String str3 = str;
        l7.a aVar = new l7.a(20, false);
        aVar.f7866w = uri;
        aVar.f7867x = str2;
        aVar.f7868y = bundle;
        return new v1.g0(str3, new v1.x(vVar), null, new v1.a0(tVar), v1.j0.K, new v1.d0(aVar));
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

    @Override // l4.u
    public final void A(long j4) {
        if (j4 < 0) {
            return;
        }
        H(10, new d0(this, j4, 0), ((l4.w) this.f7063k.f7705w).c(), true);
    }

    @Override // l4.u
    public final void B() {
        H(3, new e0(this, 6), ((l4.w) this.f7063k.f7705w).c(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final l4.k0 G(k4.h1 r31) {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.l0.G(k4.h1):l4.k0");
    }

    public final void H(final int i, final k0 k0Var, final l4.e0 e0Var, final boolean z10) {
        b0 b0Var = this.f7060g;
        if (b0Var.j()) {
            return;
        }
        if (e0Var != null) {
            y1.a0.S(b0Var.f6916l, new Runnable() { // from class: k4.i0
                @Override // java.lang.Runnable
                public final void run() {
                    k0 k0Var2 = k0Var;
                    l0 l0Var = this.f7040v;
                    b0 b0Var2 = l0Var.f7060g;
                    if (b0Var2.j()) {
                        return;
                    }
                    boolean zIsActive = ((l4.w) l0Var.f7063k.f7705w).f7765a.isActive();
                    int i10 = i;
                    l4.e0 e0Var2 = e0Var;
                    if (!zIsActive) {
                        StringBuilder sbM = l0.e.m(i10, "Ignore incoming player command before initialization. command=", ", pid=");
                        sbM.append(e0Var2.f7710a.f7713b);
                        y1.b.p("MediaSessionLegacyStub", sbM.toString());
                        return;
                    }
                    s sVarL = l0Var.L(e0Var2);
                    if (!l0Var.f.m(sVarL, i10)) {
                        if (i10 != 1 || b0Var2.f6924t.w()) {
                            return;
                        }
                        y1.b.p("MediaSessionLegacyStub", "Calling play() omitted due to COMMAND_PLAY_PAUSE not being available. If this play command has started the service for instance for playback resumption, this may prevent the service from being started into the foreground.");
                        return;
                    }
                    f9.b0 b0Var3 = b0Var2.f6911e;
                    b0Var2.s(sVarL);
                    b0Var3.getClass();
                    try {
                        k0Var2.d(sVarL);
                    } catch (RemoteException e9) {
                        y1.b.q("MediaSessionLegacyStub", "Exception in " + sVarL, e9);
                    }
                    if (z10) {
                        new SparseBooleanArray().append(i10, true);
                        b0Var2.p(sVarL);
                    }
                }
            });
            return;
        }
        y1.b.f("MediaSessionLegacyStub", "RemoteUserInfo is null, ignoring command=" + i);
    }

    public final void I(k1 k1Var, int i, k0 k0Var, l4.e0 e0Var) {
        if (e0Var != null) {
            y1.a0.S(this.f7060g.f6916l, new g2.c1(this, k1Var, i, e0Var, k0Var));
            return;
        }
        StringBuilder sb = new StringBuilder("RemoteUserInfo is null, ignoring command=");
        Object objValueOf = k1Var;
        if (k1Var == null) {
            objValueOf = Integer.valueOf(i);
        }
        sb.append(objValueOf);
        y1.b.f("MediaSessionLegacyStub", sb.toString());
    }

    public final void K(v1.g0 g0Var, boolean z10) {
        H(31, new h0(this, g0Var, z10), ((l4.w) this.f7063k.f7705w).c(), false);
    }

    public final s L(l4.e0 e0Var) {
        s sVarH = this.f.h(e0Var);
        if (sVarH == null) {
            s sVar = new s(e0Var, 0, 0, this.f7061h.b(e0Var), new j0(e0Var), Bundle.EMPTY);
            q qVarM = this.f7060g.m(sVar);
            this.f.a(e0Var, sVar, qVarM.f7136a, qVarM.f7137b);
            b0 b0Var = this.f7060g;
            if (!b0Var.f6928x || !b0.k(sVar)) {
                b0Var.f6911e.getClass();
            }
            sVarH = sVar;
        }
        h.d dVar = this.f7062j;
        long j4 = this.f7067o;
        dVar.removeMessages(1001, sVarH);
        dVar.sendMessageDelayed(dVar.obtainMessage(1001, sVarH), j4);
        return sVarH;
    }

    public final void M() {
        ua.i0 i0Var = this.f7072t;
        int i = a.f6903a;
        ua.q.d(4, "initialCapacity");
        Object[] objArr = new Object[4];
        if (i0Var.size() > 0) {
            i0Var.get(0).getClass();
            throw new ClassCastException();
        }
        ua.z0 z0VarA = a.a(ua.i0.i(0, objArr));
        this.f7071s = z0VarA;
        if (z0VarA.size() > 0) {
            z0VarA.get(0);
            throw new ClassCastException();
        }
        Bundle bundle = this.f7070r;
        bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", true);
        ua.i0 i0Var2 = this.f7071s;
        if (i0Var2.size() <= 0) {
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", true);
        } else {
            i0Var2.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final void N(h1 h1Var) {
        y1.a0.S(this.f7060g.f6916l, new f0(this, h1Var, 1));
    }

    @Override // l4.u
    public final void b(l4.o oVar) {
        if (oVar != null) {
            H(20, new d8.f(-1, this, oVar), ((l4.w) this.f7063k.f7705w).c(), false);
        }
    }

    @Override // l4.u
    public final void c(l4.o oVar, int i) {
        if (oVar != null) {
            if (i == -1 || i >= 0) {
                H(20, new d8.f(i, this, oVar), ((l4.w) this.f7063k.f7705w).c(), false);
            }
        }
    }

    @Override // l4.u
    public final void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (str.equals("androidx.media3.session.SESSION_COMMAND_MEDIA3_PLAY_REQUEST")) {
            return;
        }
        if (!str.equals("androidx.media3.session.SESSION_COMMAND_REQUEST_SESSION3_TOKEN") || resultReceiver == null) {
            k1 k1Var = new k1(str, Bundle.EMPTY);
            I(k1Var, 0, new c8.b(this, k1Var, bundle, resultReceiver), ((l4.w) this.f7063k.f7705w).c());
            return;
        }
        p1 p1Var = this.f7060g.f6914j;
        p1Var.getClass();
        String str2 = p1.f7132b;
        Bundle bundle2 = new Bundle();
        q1 q1Var = p1Var.f7134a;
        if (q1Var != null) {
            bundle2.putInt(str2, 0);
        } else {
            bundle2.putInt(str2, 1);
        }
        String str3 = p1.f7133c;
        q1Var.getClass();
        Bundle bundle3 = new Bundle();
        bundle3.putInt(q1.f, q1Var.f7151a);
        bundle3.putInt(q1.f7143g, 0);
        bundle3.putInt(q1.f7144h, 1008000300);
        bundle3.putString(q1.i, q1Var.f7152b);
        bundle3.putString(q1.f7145j, "");
        bundle3.putBinder(q1.f7147l, q1Var.f7153c);
        bundle3.putParcelable(q1.f7146k, null);
        bundle3.putBundle(q1.f7148m, q1Var.f7154d);
        bundle3.putInt(q1.f7149n, 5);
        MediaSession.Token token = q1Var.f7155e;
        if (token != null) {
            bundle3.putParcelable(q1.f7150o, token);
        }
        bundle2.putBundle(str3, bundle3);
        resultReceiver.send(0, bundle2);
    }

    @Override // l4.u
    public final void e(String str, Bundle bundle) {
        if (str.equals("androidx.media3.session.SESSION_COMMAND_MEDIA3_PLAY_REQUEST")) {
            return;
        }
        k1 k1Var = new k1(str, Bundle.EMPTY);
        I(k1Var, 0, new androidx.fragment.app.e(this, k1Var, bundle), ((l4.w) this.f7063k.f7705w).c());
    }

    @Override // l4.u
    public final void f() {
        H(12, new e0(this, 4), ((l4.w) this.f7063k.f7705w).c(), true);
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
    @Override // l4.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.content.Intent r13) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.l0.g(android.content.Intent):boolean");
    }

    @Override // l4.u
    public final void h() {
        H(1, new e0(this, 11), ((l4.w) this.f7063k.f7705w).c(), true);
    }

    @Override // l4.u
    public final void i() {
        H(1, new e0(this, 10), ((l4.w) this.f7063k.f7705w).c(), false);
    }

    @Override // l4.u
    public final void j(String str, Bundle bundle) {
        K(F(str, null, null, bundle), true);
    }

    @Override // l4.u
    public final void k(String str, Bundle bundle) {
        K(F(null, null, str, bundle), true);
    }

    @Override // l4.u
    public final void l(Uri uri, Bundle bundle) {
        K(F(null, uri, null, bundle), true);
    }

    @Override // l4.u
    public final void m() {
        H(2, new e0(this, 5), ((l4.w) this.f7063k.f7705w).c(), true);
    }

    @Override // l4.u
    public final void n(String str, Bundle bundle) {
        K(F(str, null, null, bundle), false);
    }

    @Override // l4.u
    public final void o(String str, Bundle bundle) {
        K(F(null, null, str, bundle), false);
    }

    @Override // l4.u
    public final void p(Uri uri, Bundle bundle) {
        K(F(null, uri, null, bundle), false);
    }

    @Override // l4.u
    public final void q(l4.o oVar) {
        if (oVar == null) {
            return;
        }
        H(20, new androidx.fragment.app.e(9, this, oVar), ((l4.w) this.f7063k.f7705w).c(), true);
    }

    @Override // l4.u
    public final void r() {
        H(11, new e0(this, 3), ((l4.w) this.f7063k.f7705w).c(), true);
    }

    @Override // l4.u
    public final void s(long j4) {
        H(5, new d0(this, j4, 1), ((l4.w) this.f7063k.f7705w).c(), true);
    }

    @Override // l4.u
    public final void t(final float f) {
        if (f <= 0.0f) {
            return;
        }
        H(13, new k0() { // from class: k4.c0
            @Override // k4.k0
            public final void d(s sVar) {
                this.f6933v.f7060g.f6924t.e(f);
            }
        }, ((l4.w) this.f7063k.f7705w).c(), true);
    }

    @Override // l4.u
    public final void u(l4.l0 l0Var) {
        v(l0Var);
    }

    @Override // l4.u
    public final void v(l4.l0 l0Var) {
        v1.x0 x0VarC = l.c(l0Var);
        if (x0VarC != null) {
            I(null, 40010, new e0(this, x0VarC), ((l4.w) this.f7063k.f7705w).c());
            return;
        }
        y1.b.p("MediaSessionLegacyStub", "Ignoring invalid RatingCompat " + l0Var);
    }

    @Override // l4.u
    public final void w(int i) {
        H(15, new g0(this, i, 0), ((l4.w) this.f7063k.f7705w).c(), true);
    }

    @Override // l4.u
    public final void x(int i) {
        H(14, new g0(this, i, 1), ((l4.w) this.f7063k.f7705w).c(), true);
    }

    @Override // l4.u
    public final void y() {
        boolean Z = this.f7060g.f6924t.Z(9);
        l4.c0 c0Var = this.f7063k;
        if (Z) {
            H(9, new e0(this, 8), ((l4.w) c0Var.f7705w).c(), true);
        } else {
            H(8, new e0(this, 9), ((l4.w) c0Var.f7705w).c(), true);
        }
    }

    @Override // l4.u
    public final void z() {
        boolean Z = this.f7060g.f6924t.Z(7);
        l4.c0 c0Var = this.f7063k;
        if (Z) {
            H(7, new e0(this, 1), ((l4.w) c0Var.f7705w).c(), true);
        } else {
            H(6, new e0(this, 2), ((l4.w) c0Var.f7705w).c(), true);
        }
    }
}
