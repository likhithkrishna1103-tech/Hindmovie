package pa;

import android.content.Context;
import android.os.Build;
import b8.d;
import b8.e;
import be.h;
import c6.g;
import com.bumptech.glide.manager.l;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.e9;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.g9;
import com.google.android.gms.internal.measurement.m8;
import com.google.android.gms.internal.measurement.o7;
import com.google.android.gms.internal.measurement.o8;
import com.google.android.gms.internal.measurement.q7;
import com.google.android.gms.internal.measurement.w6;
import com.google.android.gms.internal.measurement.x6;
import com.google.android.gms.internal.measurement.y6;
import com.google.android.gms.internal.measurement.z6;
import com.google.firebase.components.ComponentRegistrar;
import hf.f;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import k8.e0;
import od.k;
import ue.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class b implements e, g, com.bumptech.glide.manager.g, l, y6.a, e0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static b f10298v;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10299u;

    public /* synthetic */ b(int i) {
        this.f10299u = i;
    }

    public static ArrayList d(List list) {
        h.e(list, "protocols");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((t) obj) != t.f13046v) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(k.U(arrayList));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(((t) obj2).f13051u);
        }
        return arrayList2;
    }

    public static byte[] g(List list) {
        h.e(list, "protocols");
        f fVar = new f();
        ArrayList arrayListD = d(list);
        int size = arrayListD.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListD.get(i);
            i++;
            String str = (String) obj;
            fVar.j0(str.length());
            fVar.o0(str);
        }
        return fVar.G(fVar.f6113v);
    }

    public static boolean h() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    @Override // k8.e0
    public Object a() {
        switch (this.f10299u) {
            case 16:
                e9.f2961v.get();
                Boolean bool = (Boolean) g9.f3028h.a();
                bool.getClass();
                return bool;
            case 17:
                e9.f2961v.get();
                Boolean bool2 = (Boolean) g9.f3026e.a();
                bool2.getClass();
                return bool2;
            case 18:
                e9.f2961v.get();
                Boolean bool3 = (Boolean) g9.f3030k.a();
                bool3.getClass();
                return bool3;
            case 19:
                o7.f3141v.get();
                Boolean bool4 = (Boolean) q7.f3163b.a();
                bool4.getClass();
                return bool4;
            case 20:
                m8.f3102v.get();
                Boolean bool5 = (Boolean) o8.f3144b.a();
                bool5.getClass();
                return bool5;
            case 21:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.V.a()).longValue());
            case 22:
                w6.f3227v.get();
                Boolean bool6 = (Boolean) y6.f3249a.a();
                bool6.getClass();
                return bool6;
            case 23:
                d7.f2938v.get();
                Boolean bool7 = (Boolean) f7.f2971a.a();
                bool7.getClass();
                return bool7;
            case 24:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.S.a()).longValue());
            case 25:
                x6.f3236v.get();
                return (String) z6.f3275l.a();
            case 26:
                x6.f3236v.get();
                Long l10 = (Long) z6.f3263b.a();
                l10.getClass();
                return l10;
            case 27:
                x6.f3236v.get();
                Long l11 = (Long) z6.f3287x.a();
                l11.getClass();
                return l11;
            case 28:
                x6.f3236v.get();
                Long l12 = (Long) z6.O.a();
                l12.getClass();
                return l12;
            default:
                x6.f3236v.get();
                Long l13 = (Long) z6.f3288y.a();
                l13.getClass();
                return l13;
        }
    }

    @Override // com.bumptech.glide.manager.g
    public void b(com.bumptech.glide.manager.h hVar) {
        hVar.l();
    }

    @Override // b8.e
    public d c(Context context, String str, b8.c cVar) {
        int iN;
        d dVar = new d();
        int i = cVar.i(context, str);
        dVar.f1922a = i;
        int i10 = 1;
        int i11 = 0;
        if (i != 0) {
            iN = cVar.n(context, str, false);
            dVar.f1923b = iN;
        } else {
            iN = cVar.n(context, str, true);
            dVar.f1923b = iN;
        }
        int i12 = dVar.f1922a;
        if (i12 == 0) {
            if (iN == 0) {
                i10 = 0;
            }
            dVar.f1924c = i10;
            return dVar;
        }
        i11 = i12;
        if (i11 >= iN) {
            i10 = -1;
        }
        dVar.f1924c = i10;
        return dVar;
    }

    public boolean i(CharSequence charSequence) {
        return false;
    }

    public List j(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (na.b bVar : componentRegistrar.getComponents()) {
            String str = bVar.f8879a;
            if (str != null) {
                bVar = new na.b(str, bVar.f8880b, bVar.f8881c, bVar.f8882d, bVar.f8883e, new b2.b(str, 2, bVar), bVar.f8884g);
            }
            arrayList.add(bVar);
        }
        return arrayList;
    }

    @Override // y6.a
    public Object r() {
        try {
            return new g6.f(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        }
    }

    public /* synthetic */ b(Object obj, int i, Object obj2) {
        this.f10299u = i;
    }

    public b() {
        this.f10299u = 1;
        if (Build.VERSION.SDK_INT >= 35) {
        }
    }

    @Override // com.bumptech.glide.manager.g
    public void e(com.bumptech.glide.manager.h hVar) {
    }

    @Override // c6.g
    public void f(byte[] bArr, Object obj, MessageDigest messageDigest) {
    }
}
