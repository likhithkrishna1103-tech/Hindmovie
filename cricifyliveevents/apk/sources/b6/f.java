package b6;

import ag.u;
import ag.v;
import ag.w;
import android.app.Notification;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.IconCompat;
import androidx.emoji2.text.c0;
import androidx.emoji2.text.z;
import app.cricfy.tv.room.db.AppDatabase;
import com.google.android.gms.internal.measurement.n;
import com.google.android.gms.internal.measurement.o4;
import com.google.android.gms.internal.measurement.t;
import d1.b1;
import d1.e0;
import h0.m;
import h0.q;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import k4.b0;
import k4.f1;
import k4.j1;
import k4.k1;
import k4.l1;
import k4.s;
import n.k;
import pe.c1;
import pe.v0;
import ua.g0;
import ua.i0;
import ua.m0;
import ua.z0;
import v1.p0;
import v1.s0;
import vc.o;
import vc.u0;
import x3.p;
import y1.a0;
import yc.j;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements p, v, z7.b, xc.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1799v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f1800w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f1801x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f1802y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f1803z;

    public /* synthetic */ f(ViewGroup viewGroup, Object obj, ViewGroup viewGroup2, View view, Object obj2, int i) {
        this.f1799v = i;
        this.f1800w = obj;
        this.f1801x = viewGroup2;
        this.f1802y = view;
        this.f1803z = obj2;
    }

    public n A(String str) {
        HashMap map = (HashMap) this.f1802y;
        if (map.containsKey(str)) {
            return (n) map.get(str);
        }
        f fVar = (f) this.f1800w;
        if (fVar != null) {
            return fVar.A(str);
        }
        throw new IllegalArgumentException(l0.e.j(str, " is not defined"));
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x020a  */
    @Override // x3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(byte[] r43, int r44, int r45, x3.o r46, y1.h r47) {
        /*
            Method dump skipped, instruction units count: 1226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.f.C(byte[], int, int, x3.o, y1.h):void");
    }

    @Override // x3.p
    public int D() {
        switch (this.f1799v) {
        }
        return 2;
    }

    public void a(Object obj, s sVar, l1 l1Var, s0 s0Var) {
        synchronized (this.f1800w) {
            try {
                s sVarH = h(obj);
                if (sVarH == null) {
                    ((v.e) this.f1801x).put(obj, sVar);
                    ((v.e) this.f1802y).put(sVar, new k4.f(obj, new j1(), l1Var, s0Var));
                } else {
                    k4.f fVar = (k4.f) ((v.e) this.f1802y).get(sVarH);
                    y1.d.h(fVar);
                    fVar.f6954d = l1Var;
                    fVar.f6955e = s0Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(s sVar, int i, k4.e eVar) {
        synchronized (this.f1800w) {
            try {
                k4.f fVar = (k4.f) ((v.e) this.f1802y).get(sVar);
                if (fVar != null) {
                    s0 s0Var = fVar.f6956g;
                    s0Var.getClass();
                    o4 o4Var = new o4(8);
                    o4Var.d(s0Var.f12990a);
                    o4Var.b(i);
                    fVar.f6956g = new s0(o4Var.e());
                    fVar.f6953c.add(eVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(k4.f fVar) {
        b0 b0Var = (b0) ((WeakReference) this.f1803z).get();
        if (b0Var == null) {
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        while (atomicBoolean.get()) {
            atomicBoolean.set(false);
            k4.e eVar = (k4.e) fVar.f6953c.poll();
            if (eVar == null) {
                fVar.f = false;
                return;
            }
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
            k4.f fVar2 = fVar;
            a0.S(b0Var.f6916l, new androidx.fragment.app.d(b0Var, h(fVar.f6951a), new k4.d(this, eVar, atomicBoolean2, fVar2, atomicBoolean)));
            atomicBoolean2.set(false);
            fVar = fVar2;
        }
    }

    @Override // ag.v
    public w d() {
        return (bg.d) this.f1802y;
    }

    public void e(final s sVar) {
        synchronized (this.f1800w) {
            try {
                k4.f fVar = (k4.f) ((v.e) this.f1802y).get(sVar);
                if (fVar == null) {
                    return;
                }
                final s0 s0Var = fVar.f6956g;
                fVar.f6956g = s0.f12988b;
                fVar.f6953c.add(new k4.e(sVar, s0Var) { // from class: k4.c

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ s f6932b;

                    @Override // k4.e
                    public final ya.w run() {
                        b0 b0Var = (b0) ((WeakReference) this.f6931a.f1803z).get();
                        if (b0Var != null) {
                            b0Var.p(this.f6932b);
                        }
                        return ya.u.f15014w;
                    }
                });
                if (fVar.f) {
                    return;
                }
                fVar.f = true;
                c(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public s0 f(s sVar) {
        synchronized (this.f1800w) {
            try {
                k4.f fVar = (k4.f) ((v.e) this.f1802y).get(sVar);
                if (fVar == null) {
                    return null;
                }
                return fVar.f6955e;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public i0 g() {
        i0 i0VarK;
        synchronized (this.f1800w) {
            i0VarK = i0.k(((v.e) this.f1801x).values());
        }
        return i0VarK;
    }

    @Override // qd.a
    public Object get() {
        switch (this.f1799v) {
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return new nc.p((Executor) ((qd.a) this.f1800w).get(), (e8.d) ((qd.a) this.f1801x).get(), (androidx.emoji2.text.v) ((androidx.emoji2.text.v) this.f1802y).get(), (f8.c) ((qd.a) this.f1803z).get());
            default:
                return new o((ab.g) ((ma.e) this.f1800w).f8417v, (j) ((qd.a) this.f1801x).get(), (vd.h) ((qd.a) this.f1802y).get(), (u0) ((xc.c) this.f1803z).get());
        }
    }

    public s h(Object obj) {
        s sVar;
        synchronized (this.f1800w) {
            sVar = (s) ((v.e) this.f1801x).get(obj);
        }
        return sVar;
    }

    public p0 i(s sVar) {
        synchronized (this.f1800w) {
            try {
                return ((k4.f) ((v.e) this.f1802y).get(sVar)) != null ? null : null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public f1 j(s sVar) {
        synchronized (this.f1800w) {
            try {
                return ((k4.f) ((v.e) this.f1802y).get(sVar)) != null ? null : null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public j1 k(s sVar) {
        k4.f fVar;
        synchronized (this.f1800w) {
            fVar = (k4.f) ((v.e) this.f1802y).get(sVar);
        }
        if (fVar != null) {
            return fVar.f6952b;
        }
        return null;
    }

    public boolean l(s sVar) {
        boolean z10;
        synchronized (this.f1800w) {
            z10 = ((v.e) this.f1802y).get(sVar) != null;
        }
        return z10;
    }

    public boolean m(s sVar, int i) {
        k4.f fVar;
        synchronized (this.f1800w) {
            fVar = (k4.f) ((v.e) this.f1802y).get(sVar);
        }
        b0 b0Var = (b0) ((WeakReference) this.f1803z).get();
        return fVar != null && fVar.f6955e.a(i) && b0Var != null && b0Var.f6924t.u().a(i);
    }

    public boolean n(s sVar, int i) {
        k4.f fVar;
        synchronized (this.f1800w) {
            fVar = (k4.f) ((v.e) this.f1802y).get(sVar);
        }
        if (fVar != null) {
            l1 l1Var = fVar.f6954d;
            l1Var.getClass();
            y1.d.a("Use contains(Command) for custom command", i != 0);
            Iterator<E> it = l1Var.f7076a.iterator();
            while (it.hasNext()) {
                if (((k1) it.next()).f7055a == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean o(s sVar, k1 k1Var) {
        k4.f fVar;
        synchronized (this.f1800w) {
            fVar = (k4.f) ((v.e) this.f1802y).get(sVar);
        }
        if (fVar == null) {
            return false;
        }
        m0 m0Var = fVar.f6954d.f7076a;
        k1Var.getClass();
        return m0Var.contains(k1Var);
    }

    public void p(s sVar) {
        synchronized (this.f1800w) {
            try {
                k4.f fVar = (k4.f) ((v.e) this.f1802y).remove(sVar);
                if (fVar == null) {
                    return;
                }
                ((v.e) this.f1801x).remove(fVar.f6951a);
                fVar.f6952b.d();
                b0 b0Var = (b0) ((WeakReference) this.f1803z).get();
                if (b0Var == null || b0Var.j()) {
                    return;
                }
                a0.S(b0Var.f6916l, new k4.b(b0Var, sVar, 0));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // x3.p
    public /* synthetic */ x3.g r(byte[] bArr, int i, int i10) {
        int i11 = this.f1799v;
        return l0.e.a(this, bArr, i10);
    }

    @Override // x3.p
    public /* synthetic */ void reset() {
        int i = this.f1799v;
    }

    @Override // ag.v
    public u s() {
        return (bg.c) this.f1803z;
    }

    public String toString() {
        switch (this.f1799v) {
            case 3:
                String string = ((Socket) this.f1800w).toString();
                ge.i.d(string, "toString(...)");
                return string;
            default:
                return super.toString();
        }
    }

    public n u(n nVar) {
        return ((t) this.f1801x).c(this, nVar);
    }

    public n v(com.google.android.gms.internal.measurement.d dVar) {
        n nVarC = n.f2536b;
        Iterator itL = dVar.l();
        while (itL.hasNext()) {
            nVarC = ((t) this.f1801x).c(this, dVar.n(((Integer) itL.next()).intValue()));
            if (nVarC instanceof com.google.android.gms.internal.measurement.f) {
                break;
            }
        }
        return nVarC;
    }

    public f w() {
        return new f(this, (t) this.f1801x);
    }

    public boolean x(String str) {
        if (((HashMap) this.f1802y).containsKey(str)) {
            return true;
        }
        f fVar = (f) this.f1800w;
        if (fVar != null) {
            return fVar.x(str);
        }
        return false;
    }

    public void y(String str, n nVar) {
        f fVar;
        HashMap map = (HashMap) this.f1802y;
        if (!map.containsKey(str) && (fVar = (f) this.f1800w) != null && fVar.x(str)) {
            fVar.y(str, nVar);
        } else {
            if (((HashMap) this.f1803z).containsKey(str)) {
                return;
            }
            if (nVar == null) {
                map.remove(str);
            } else {
                map.put(str, nVar);
            }
        }
    }

    public void z(String str, n nVar) {
        HashMap map = (HashMap) this.f1802y;
        if (((HashMap) this.f1803z).containsKey(str)) {
            return;
        }
        if (nVar == null) {
            map.remove(str);
        } else {
            map.put(str, nVar);
        }
    }

    public /* synthetic */ f(qd.a aVar, qd.a aVar2, qd.a aVar3, qd.a aVar4, int i) {
        this.f1799v = i;
        this.f1800w = aVar;
        this.f1801x = aVar2;
        this.f1802y = aVar3;
        this.f1803z = aVar4;
    }

    public f(f fVar, t tVar) {
        this.f1799v = 4;
        this.f1802y = new HashMap();
        this.f1803z = new HashMap();
        this.f1800w = fVar;
        this.f1801x = tVar;
    }

    public f(pe.v vVar, e0 e0Var, d1.e eVar) {
        this.f1799v = 5;
        this.f1800w = vVar;
        this.f1801x = eVar;
        this.f1802y = com.bumptech.glide.d.a(Integer.MAX_VALUE, null, 6);
        this.f1803z = new pc.c(6);
        v0 v0Var = (v0) vVar.b().C(pe.t.f10271w);
        if (v0Var != null) {
            ((c1) v0Var).K(true, new pe.j(2, new b1(1, e0Var, this)));
        }
    }

    public f(AppDatabase appDatabase) {
        this.f1799v = 0;
        this.f1800w = appDatabase;
        this.f1801x = new e(0);
        this.f1802y = new e(1);
        this.f1803z = new e(2);
    }

    public f(Socket socket) {
        this.f1799v = 3;
        this.f1800w = socket;
        this.f1801x = new AtomicInteger();
        this.f1802y = new bg.d(this);
        this.f1803z = new bg.c(this);
    }

    public f(int i) {
        this.f1799v = i;
        switch (i) {
            case 10:
                this.f1800w = new v.e(0);
                this.f1801x = new SparseArray();
                this.f1802y = new v.h();
                this.f1803z = new v.e(0);
                break;
            default:
                this.f1800w = new y1.t();
                this.f1801x = new y1.t();
                this.f1802y = new a4.a();
                break;
        }
    }

    private final /* synthetic */ void q() {
    }

    private final /* synthetic */ void t() {
    }

    public f(List list) {
        int i;
        this.f1799v = 7;
        this.f1800w = new y1.t();
        this.f1801x = new y1.t();
        f4.a aVar = new f4.a();
        this.f1802y = aVar;
        String strTrim = new String((byte[]) list.get(0), StandardCharsets.UTF_8).trim();
        int i10 = a0.f14551a;
        for (String str : strTrim.split("\\r?\\n", -1)) {
            if (str.startsWith("palette: ")) {
                String[] strArrSplit = str.substring(9).split(",", -1);
                aVar.f3957d = new int[strArrSplit.length];
                for (int i11 = 0; i11 < strArrSplit.length; i11++) {
                    int[] iArr = aVar.f3957d;
                    try {
                        i = Integer.parseInt(strArrSplit[i11].trim(), 16);
                    } catch (RuntimeException unused) {
                        i = 0;
                    }
                    iArr[i11] = i;
                }
            } else if (str.startsWith("size: ")) {
                String[] strArrSplit2 = str.substring(6).trim().split("x", -1);
                if (strArrSplit2.length == 2) {
                    try {
                        aVar.f3958e = Integer.parseInt(strArrSplit2[0]);
                        aVar.f = Integer.parseInt(strArrSplit2[1]);
                        aVar.f3955b = true;
                    } catch (RuntimeException e9) {
                        y1.b.q("VobsubParser", "Parsing IDX failed", e9);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(m mVar) {
        Bundle bundle;
        int i;
        ArrayList arrayList;
        Bundle bundle2;
        int i10;
        this.f1799v = 8;
        new ArrayList();
        this.f1803z = new Bundle();
        this.f1802y = mVar;
        Context context = mVar.f5449a;
        ArrayList arrayList2 = mVar.f5466t;
        ArrayList arrayList3 = mVar.f5451c;
        ArrayList arrayList4 = mVar.f5452d;
        this.f1800w = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1801x = h0.o.a(context, mVar.f5463q);
        } else {
            this.f1801x = new Notification.Builder(context);
        }
        Notification notification = mVar.f5465s;
        Context context2 = null;
        ((Notification.Builder) this.f1801x).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(mVar.f5453e).setContentText(mVar.f).setContentInfo(null).setContentIntent(mVar.f5454g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(mVar.i).setProgress(0, 0, false);
        Notification.Builder builder = (Notification.Builder) this.f1801x;
        IconCompat iconCompat = mVar.f5455h;
        builder.setLargeIcon(iconCompat == null ? null : iconCompat.f(context));
        ((Notification.Builder) this.f1801x).setSubText(null).setUsesChronometer(false).setPriority(mVar.f5456j);
        ArrayList arrayList5 = mVar.f5450b;
        int size = arrayList5.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList5.get(i11);
            i11++;
            h0.g gVar = (h0.g) obj;
            int i12 = Build.VERSION.SDK_INT;
            if (gVar.f5440b == null && (i10 = gVar.f5443e) != 0) {
                gVar.f5440b = IconCompat.b(i10);
            }
            IconCompat iconCompat2 = gVar.f5440b;
            boolean z10 = gVar.f5441c;
            Bundle bundle3 = gVar.f5439a;
            ArrayList arrayList6 = arrayList5;
            ArrayList arrayList7 = arrayList3;
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCompat2 != null ? iconCompat2.f(context2) : context2, gVar.f, gVar.f5444g);
            if (bundle3 != null) {
                bundle2 = new Bundle(bundle3);
            } else {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android.support.allowGeneratedReplies", z10);
            if (i12 >= 24) {
                h0.n.b(builder2, z10);
            }
            bundle2.putInt("android.support.action.semanticAction", 0);
            if (i12 >= 28) {
                h0.p.a(builder2);
            }
            if (i12 >= 29) {
                h0.d.d(builder2);
            }
            if (i12 >= 31) {
                q.a(builder2);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", gVar.f5442d);
            builder2.addExtras(bundle2);
            ((Notification.Builder) this.f1801x).addAction(builder2.build());
            arrayList5 = arrayList6;
            arrayList3 = arrayList7;
            context2 = null;
        }
        ArrayList arrayList8 = arrayList3;
        Bundle bundle4 = mVar.f5460n;
        if (bundle4 != null) {
            ((Bundle) this.f1803z).putAll(bundle4);
        }
        int i13 = Build.VERSION.SDK_INT;
        ((Notification.Builder) this.f1801x).setShowWhen(mVar.f5457k);
        ((Notification.Builder) this.f1801x).setLocalOnly(mVar.f5459m);
        ((Notification.Builder) this.f1801x).setGroup(null);
        ((Notification.Builder) this.f1801x).setSortKey(null);
        ((Notification.Builder) this.f1801x).setGroupSummary(false);
        ((Notification.Builder) this.f1801x).setCategory(null);
        ((Notification.Builder) this.f1801x).setColor(mVar.f5461o);
        ((Notification.Builder) this.f1801x).setVisibility(mVar.f5462p);
        ((Notification.Builder) this.f1801x).setPublicVersion(null);
        ((Notification.Builder) this.f1801x).setSound(notification.sound, notification.audioAttributes);
        if (i13 < 28) {
            if (arrayList8 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList8.size());
                Iterator it = arrayList8.iterator();
                if (it.hasNext()) {
                    throw q4.a.l(it);
                }
            }
            if (arrayList != null) {
                if (arrayList2 == null) {
                    arrayList2 = arrayList;
                } else {
                    v.f fVar = new v.f(arrayList2.size() + arrayList.size());
                    fVar.addAll(arrayList);
                    fVar.addAll(arrayList2);
                    arrayList2 = new ArrayList(fVar);
                }
            }
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            int size2 = arrayList2.size();
            int i14 = 0;
            while (i14 < size2) {
                Object obj2 = arrayList2.get(i14);
                i14++;
                ((Notification.Builder) this.f1801x).addPerson((String) obj2);
            }
        }
        if (arrayList4.size() > 0) {
            if (mVar.f5460n == null) {
                mVar.f5460n = new Bundle();
            }
            Bundle bundle5 = mVar.f5460n.getBundle("android.car.EXTENSIONS");
            bundle5 = bundle5 == null ? new Bundle() : bundle5;
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            for (int i15 = 0; i15 < arrayList4.size(); i15++) {
                String string = Integer.toString(i15);
                h0.g gVar2 = (h0.g) arrayList4.get(i15);
                Bundle bundle8 = new Bundle();
                if (gVar2.f5440b == null && (i = gVar2.f5443e) != 0) {
                    gVar2.f5440b = IconCompat.b(i);
                }
                IconCompat iconCompat3 = gVar2.f5440b;
                Bundle bundle9 = gVar2.f5439a;
                bundle8.putInt("icon", iconCompat3 != null ? iconCompat3.c() : 0);
                bundle8.putCharSequence("title", gVar2.f);
                bundle8.putParcelable("actionIntent", gVar2.f5444g);
                if (bundle9 != null) {
                    bundle = new Bundle(bundle9);
                } else {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android.support.allowGeneratedReplies", gVar2.f5441c);
                bundle8.putBundle("extras", bundle);
                bundle8.putParcelableArray("remoteInputs", null);
                bundle8.putBoolean("showsUserInterface", gVar2.f5442d);
                bundle8.putInt("semanticAction", 0);
                bundle7.putBundle(string, bundle8);
            }
            bundle5.putBundle("invisible_actions", bundle7);
            bundle6.putBundle("invisible_actions", bundle7);
            if (mVar.f5460n == null) {
                mVar.f5460n = new Bundle();
            }
            mVar.f5460n.putBundle("android.car.EXTENSIONS", bundle5);
            ((Bundle) this.f1803z).putBundle("android.car.EXTENSIONS", bundle6);
        }
        int i16 = Build.VERSION.SDK_INT;
        if (i16 >= 24) {
            ((Notification.Builder) this.f1801x).setExtras(mVar.f5460n);
            h0.n.c((Notification.Builder) this.f1801x);
        }
        if (i16 >= 26) {
            h0.o.b((Notification.Builder) this.f1801x);
            h0.o.d((Notification.Builder) this.f1801x);
            h0.o.e((Notification.Builder) this.f1801x);
            h0.o.f((Notification.Builder) this.f1801x);
            h0.o.c((Notification.Builder) this.f1801x);
            if (!TextUtils.isEmpty(mVar.f5463q)) {
                ((Notification.Builder) this.f1801x).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i16 >= 28) {
            Iterator it2 = arrayList8.iterator();
            if (it2.hasNext()) {
                throw q4.a.l(it2);
            }
        }
        if (i16 >= 29) {
            h0.d.b((Notification.Builder) this.f1801x, mVar.f5464r);
            h0.d.c((Notification.Builder) this.f1801x);
        }
    }

    public f(b0 b0Var) {
        this.f1799v = 9;
        this.f1801x = new v.e(0);
        this.f1802y = new v.e(0);
        this.f1800w = new Object();
        this.f1803z = new WeakReference(b0Var);
    }

    public f(Typeface typeface, l1.b bVar) {
        int i;
        int i10;
        int i11;
        int i12;
        this.f1799v = 2;
        this.f1803z = typeface;
        this.f1800w = bVar;
        this.f1802y = new z(1024);
        int iA = bVar.a(6);
        if (iA != 0) {
            int i13 = iA + bVar.f7624v;
            i = ((ByteBuffer) bVar.f7627y).getInt(((ByteBuffer) bVar.f7627y).getInt(i13) + i13);
        } else {
            i = 0;
        }
        this.f1801x = new char[i * 2];
        int iA2 = bVar.a(6);
        if (iA2 != 0) {
            int i14 = iA2 + bVar.f7624v;
            i10 = ((ByteBuffer) bVar.f7627y).getInt(((ByteBuffer) bVar.f7627y).getInt(i14) + i14);
        } else {
            i10 = 0;
        }
        for (int i15 = 0; i15 < i10; i15++) {
            c0 c0Var = new c0(this, i15);
            l1.a aVarB = c0Var.b();
            int iA3 = aVarB.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) aVarB.f7627y).getInt(iA3 + aVarB.f7624v) : 0, (char[]) this.f1801x, i15 * 2);
            l1.a aVarB2 = c0Var.b();
            int iA4 = aVarB2.a(16);
            if (iA4 != 0) {
                int i16 = iA4 + aVarB2.f7624v;
                i11 = ((ByteBuffer) aVarB2.f7627y).getInt(((ByteBuffer) aVarB2.f7627y).getInt(i16) + i16);
            } else {
                i11 = 0;
            }
            com.bumptech.glide.f.d("invalid metadata codepoint length", i11 > 0);
            z zVar = (z) this.f1802y;
            l1.a aVarB3 = c0Var.b();
            int iA5 = aVarB3.a(16);
            if (iA5 != 0) {
                int i17 = iA5 + aVarB3.f7624v;
                i12 = ((ByteBuffer) aVarB3.f7627y).getInt(((ByteBuffer) aVarB3.f7627y).getInt(i17) + i17);
            } else {
                i12 = 0;
            }
            zVar.a(c0Var, 0, i12 - 1);
        }
    }

    public f(Context context, View view) {
        this.f1799v = 11;
        int i = g.a.popupMenuStyle;
        this.f1801x = view;
        k kVar = new k(context);
        this.f1800w = kVar;
        kVar.f8523e = new kf.i(10, this);
        n.u uVar = new n.u(context, kVar, view, false, i, 0);
        this.f1802y = uVar;
        uVar.f = 0;
        uVar.f8587j = new n.t(1, this);
    }

    public f(z0 z0Var, z1.i iVar, z1.i iVar2, z1.i iVar3) {
        Object objK;
        this.f1799v = 16;
        if (z0Var != null) {
            objK = i0.k(z0Var);
        } else {
            g0 g0Var = i0.f12341w;
            objK = z0.f12413z;
        }
        this.f1800w = objK;
        this.f1801x = iVar;
        this.f1802y = iVar2;
        this.f1803z = iVar3;
    }

    public f(s2.l1 l1Var, boolean[] zArr) {
        this.f1799v = 12;
        this.f1800w = l1Var;
        this.f1801x = zArr;
        int i = l1Var.f11262a;
        this.f1802y = new boolean[i];
        this.f1803z = new boolean[i];
    }
}
