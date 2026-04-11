package p2;

import aa.j0;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.cardview.widget.CardView;
import com.google.android.gms.common.api.Status;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledExecutorService;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import l5.h0;
import o2.b1;
import q4.c1;
import q4.g1;
import q4.x0;
import q9.t;
import r4.p;
import ue.q;
import ue.x;
import ue.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class c implements ue.e, y4.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10129u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f10130v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f10131w;

    public /* synthetic */ c(int i, Object obj) {
        this.f10129u = i;
        this.f10131w = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #2 {all -> 0x00a0, blocks: (B:20:0x004a, B:22:0x004e, B:25:0x005f, B:29:0x0066, B:31:0x006e, B:33:0x0079, B:32:0x0074, B:27:0x0063, B:28:0x0065, B:45:0x0098, B:46:0x009f, B:24:0x005a), top: B:71:0x004a, outer: #4, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0098 A[Catch: all -> 0x00a0, TRY_ENTER, TryCatch #2 {all -> 0x00a0, blocks: (B:20:0x004a, B:22:0x004e, B:25:0x005f, B:29:0x0066, B:31:0x006e, B:33:0x0079, B:32:0x0074, B:27:0x0063, B:28:0x0065, B:45:0x0098, B:46:0x009f, B:24:0x005a), top: B:71:0x004a, outer: #4, inners: #3 }] */
    @Override // y4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public y4.a a(java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.c.a(java.lang.String):y4.a");
    }

    public void b(Object obj, String str) {
        ((ArrayList) this.f10130v).add(str + "=" + String.valueOf(obj));
    }

    public void c(x0 x0Var, b2.m mVar) {
        s.i iVar = (s.i) this.f10130v;
        g1 g1VarA = (g1) iVar.get(x0Var);
        if (g1VarA == null) {
            g1VarA = g1.a();
            iVar.put(x0Var, g1VarA);
        }
        g1VarA.f10804c = mVar;
        g1VarA.f10802a |= 8;
    }

    @Override // ue.e
    public void d(IOException iOException) {
        ga.b.E((pc.l) this.f10130v, false, iOException.getMessage());
    }

    public synchronized void e() {
        if (!((LinkedHashSet) this.f10130v).isEmpty()) {
            ((yb.m) this.f10131w).e(0L);
        }
    }

    public void f() {
        int[] iArr = (int[]) this.f10130v;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f10131w = null;
    }

    public void g() {
        String str = (String) this.f10130v;
        try {
            za.c cVar = (za.c) this.f10131w;
            cVar.getClass();
            new File((File) cVar.f14936c, str).createNewFile();
        } catch (IOException e10) {
            Log.e("FirebaseCrashlytics", "Error creating marker: ".concat(str), e10);
        }
    }

    public void h(int i) {
        int[] iArr = (int[]) this.f10130v;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.f10130v = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int length = iArr.length;
            while (length <= i) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f10130v = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.f10130v;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public synchronized List i(String str) {
        List arrayList;
        try {
            if (!((ArrayList) this.f10130v).contains(str)) {
                ((ArrayList) this.f10130v).add(str);
            }
            arrayList = (List) ((HashMap) this.f10131w).get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                ((HashMap) this.f10131w).put(str, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    @Override // ue.e
    public void j(x xVar) throws IOException {
        Charset charsetA;
        String str;
        pc.l lVar = (pc.l) this.f10130v;
        z zVar = xVar.A;
        boolean z2 = false;
        if (zVar == null) {
            ga.b.E(lVar, false, "error");
            return;
        }
        hf.h hVarV = zVar.v();
        try {
            q qVarD = zVar.d();
            if (qVarD == null || (charsetA = qVarD.a(ie.a.f6599a)) == null) {
                charsetA = ie.a.f6599a;
            }
            String strD0 = hVarV.d0(ve.b.q(hVarV, charsetA));
            hVarV.close();
            if (((Context) this.f10131w) != null) {
                if (strD0.startsWith("{") || strD0.startsWith("[")) {
                    str = strD0;
                } else {
                    try {
                        Charset charset = StandardCharsets.UTF_8;
                        byte[] bytes = "m5Kl5nk4xK1kN7pN".getBytes(charset);
                        byte[] bytes2 = "k5K4nM8mKlNL7l15".getBytes(charset);
                        byte[] bArrDecode = Base64.decode(strD0, 0);
                        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
                        IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
                        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        cipher.init(2, secretKeySpec, ivParameterSpec);
                        str = new String(cipher.doFinal(bArrDecode), charset);
                    } catch (Exception unused) {
                        str = "";
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    strD0 = str;
                }
            }
            int i = xVar.f13069x;
            if (200 <= i && i < 300) {
                z2 = true;
            }
            ga.b.E(lVar, z2, strD0);
            xVar.close();
        } finally {
        }
    }

    public synchronized ArrayList k(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) this.f10130v;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            List<s6.c> list = (List) ((HashMap) this.f10131w).get((String) obj);
            if (list != null) {
                for (s6.c cVar : list) {
                    if ((cVar.f11869a.isAssignableFrom(cls) && cls2.isAssignableFrom(cVar.f11870b)) && !arrayList.contains(cVar.f11870b)) {
                        arrayList.add(cVar.f11870b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized Map l() {
        try {
            if (((Map) this.f10131w) == null) {
                this.f10131w = Collections.unmodifiableMap(new HashMap((HashMap) this.f10130v));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Map) this.f10131w;
    }

    public Object m(t tVar) {
        return (h0) this.f10131w;
    }

    public Object n(float f, float f4, Object obj, Object obj2, float f10, float f11, float f12) {
        t tVar = (t) this.f10130v;
        tVar.f11151a = f;
        tVar.f11152b = f4;
        tVar.f = obj;
        tVar.f11156g = obj2;
        tVar.f11153c = f10;
        tVar.f11154d = f11;
        tVar.f11155e = f12;
        return m(tVar);
    }

    public void o() throws IOException {
        String str = (String) this.f10130v;
        if (((FileChannel) this.f10131w) != null) {
            return;
        }
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileChannel channel = new FileOutputStream(file).getChannel();
            this.f10131w = channel;
            if (channel != null) {
                channel.lock();
            }
        } catch (Throwable th) {
            FileChannel fileChannel = (FileChannel) this.f10131w;
            if (fileChannel != null) {
                fileChannel.close();
            }
            this.f10131w = null;
            throw new IllegalStateException(e6.j.n("Unable to lock file: '", str, "'."), th);
        }
    }

    public void p(int i, int i10) {
        int[] iArr = (int[]) this.f10130v;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i11 = i + i10;
        h(i11);
        int[] iArr2 = (int[]) this.f10130v;
        System.arraycopy(iArr2, i, iArr2, i11, (iArr2.length - i) - i10);
        Arrays.fill((int[]) this.f10130v, i, i11, -1);
        ArrayList arrayList = (ArrayList) this.f10131w;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            c1 c1Var = (c1) ((ArrayList) this.f10131w).get(size);
            int i12 = c1Var.f10756u;
            if (i12 >= i) {
                c1Var.f10756u = i12 + i10;
            }
        }
    }

    public void q(int i, int i10) {
        int[] iArr = (int[]) this.f10130v;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i11 = i + i10;
        h(i11);
        int[] iArr2 = (int[]) this.f10130v;
        System.arraycopy(iArr2, i11, iArr2, i, (iArr2.length - i) - i10);
        int[] iArr3 = (int[]) this.f10130v;
        Arrays.fill(iArr3, iArr3.length - i10, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.f10131w;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            c1 c1Var = (c1) ((ArrayList) this.f10131w).get(size);
            int i12 = c1Var.f10756u;
            if (i12 >= i) {
                if (i12 < i11) {
                    ((ArrayList) this.f10131w).remove(size);
                } else {
                    c1Var.f10756u = i12 - i10;
                }
            }
        }
    }

    public void r(int i, Bundle bundle) {
        Locale locale = Locale.US;
        String str = "Analytics listener received message. ID: " + i + ", Extras: " + bundle;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str, null);
        }
        String string = bundle.getString("name");
        if (string != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            ra.b bVar = "clx".equals(bundle2.getString("_o")) ? (kc.b) this.f10130v : (q0.e) this.f10131w;
            if (bVar == null) {
                return;
            }
            bVar.l(string, bundle2);
        }
    }

    public b2.m s(x0 x0Var, int i) {
        g1 g1Var;
        b2.m mVar;
        s.i iVar = (s.i) this.f10130v;
        int iD = iVar.d(x0Var);
        if (iD >= 0 && (g1Var = (g1) iVar.j(iD)) != null) {
            int i10 = g1Var.f10802a;
            if ((i10 & i) != 0) {
                int i11 = i10 & (~i);
                g1Var.f10802a = i11;
                if (i == 4) {
                    mVar = g1Var.f10803b;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    mVar = g1Var.f10804c;
                }
                if ((i11 & 12) == 0) {
                    iVar.h(iD);
                    g1Var.f10802a = 0;
                    g1Var.f10803b = null;
                    g1Var.f10804c = null;
                    g1.f10801d.b(g1Var);
                }
                return mVar;
            }
        }
        return null;
    }

    public void t(x0 x0Var) {
        g1 g1Var = (g1) ((s.i) this.f10130v).get(x0Var);
        if (g1Var == null) {
            return;
        }
        g1Var.f10802a &= -2;
    }

    public String toString() {
        switch (this.f10129u) {
            case 15:
                StringBuilder sb2 = new StringBuilder(100);
                sb2.append(this.f10131w.getClass().getSimpleName());
                sb2.append('{');
                ArrayList arrayList = (ArrayList) this.f10130v;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb2.append((String) arrayList.get(i));
                    if (i < size - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append('}');
                return sb2.toString();
            case 20:
                String string = "[ ";
                if (((v.f) this.f10130v) != null) {
                    for (int i10 = 0; i10 < 9; i10++) {
                        StringBuilder sbB = v.e.b(string);
                        sbB.append(((v.f) this.f10130v).B[i10]);
                        sbB.append(" ");
                        string = sbB.toString();
                    }
                }
                return string + "] " + ((v.f) this.f10130v);
            default:
                return super.toString();
        }
    }

    public void u(x0 x0Var) {
        s.g gVar = (s.g) this.f10131w;
        int i = gVar.i() - 1;
        while (true) {
            if (i < 0) {
                break;
            }
            if (x0Var == gVar.j(i)) {
                Object[] objArr = gVar.f11629w;
                Object obj = objArr[i];
                Object obj2 = s.h.f11631a;
                if (obj != obj2) {
                    objArr[i] = obj2;
                    gVar.f11627u = true;
                }
            } else {
                i--;
            }
        }
        g1 g1Var = (g1) ((s.i) this.f10130v).remove(x0Var);
        if (g1Var != null) {
            g1Var.f10802a = 0;
            g1Var.f10803b = null;
            g1Var.f10804c = null;
            g1.f10801d.b(g1Var);
        }
    }

    public void v(int i, int i10, int i11, int i12) {
        CardView cardView = (CardView) this.f10131w;
        cardView.f959x.set(i, i10, i11, i12);
        Rect rect = cardView.f958w;
        super/*android.widget.FrameLayout*/.setPadding(i + rect.left, i10 + rect.top, i11 + rect.right, i12 + rect.bottom);
    }

    public w2.h0 w(int i) {
        int i10 = 0;
        while (true) {
            int[] iArr = (int[]) this.f10130v;
            if (i10 >= iArr.length) {
                s1.b.g("BaseMediaChunkOutput", "Unmatched track of type: " + i);
                return new w2.n();
            }
            if (i == iArr[i10]) {
                return ((b1[]) this.f10131w)[i10];
            }
            i10++;
        }
    }

    public void x(boolean z2, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.f10130v)) {
            map = new HashMap((Map) this.f10130v);
        }
        synchronized (((Map) this.f10131w)) {
            map2 = new HashMap((Map) this.f10131w);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z2 || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z2 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((o8.h) entry2.getKey()).b(new c2.o(status));
            }
        }
    }

    public /* synthetic */ c(int i, boolean z2) {
        this.f10129u = i;
    }

    public /* synthetic */ c(Object obj, int i, Object obj2) {
        this.f10129u = i;
        this.f10130v = obj;
        this.f10131w = obj2;
    }

    public c(IBinder iBinder) throws RemoteException {
        this.f10129u = 1;
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if (Objects.equals(interfaceDescriptor, "android.os.IMessenger")) {
            this.f10130v = new Messenger(iBinder);
            this.f10131w = null;
        } else if (Objects.equals(interfaceDescriptor, "com.google.android.gms.iid.IMessengerCompat")) {
            this.f10131w = new p7.g(iBinder);
            this.f10130v = null;
        } else {
            Log.w("MessengerIpcClient", "Invalid interface descriptor: ".concat(String.valueOf(interfaceDescriptor)));
            throw new RemoteException();
        }
    }

    public /* synthetic */ c(Object obj) {
        this.f10129u = 15;
        this.f10131w = obj;
        this.f10130v = new ArrayList();
    }

    public c(String str) {
        this.f10129u = 10;
        this.f10130v = str.concat(".lck");
    }

    public c(int i) {
        this.f10129u = i;
        switch (i) {
            case 9:
                this.f10130v = new Rect();
                this.f10131w = new Rect();
                break;
            case 11:
                this.f10130v = new ArrayList();
                this.f10131w = new HashMap();
                break;
            case 12:
                this.f10130v = Collections.synchronizedMap(new WeakHashMap());
                this.f10131w = Collections.synchronizedMap(new WeakHashMap());
                break;
            case 16:
                q7.e eVar = q7.e.f11038d;
                this.f10130v = new SparseIntArray();
                this.f10131w = eVar;
                break;
            case 21:
                this.f10130v = new HashMap();
                break;
            case 24:
                this.f10130v = new t();
                this.f10131w = null;
                break;
            default:
                this.f10130v = new s.i(0);
                this.f10131w = new s.g();
                break;
        }
    }

    public c(h0 h0Var) {
        this.f10129u = 24;
        this.f10130v = new t();
        this.f10131w = h0Var;
    }

    public c(ga.g gVar, ob.d dVar, yb.g gVar2, yb.c cVar, Context context, yb.j jVar, ScheduledExecutorService scheduledExecutorService) {
        this.f10129u = 25;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f10130v = linkedHashSet;
        this.f10131w = new yb.m(gVar, dVar, gVar2, cVar, context, linkedHashSet, jVar, scheduledExecutorService);
    }

    public c(p pVar, y4.b bVar) {
        this.f10129u = 8;
        be.h.e(bVar, "actual");
        this.f10131w = pVar;
        this.f10130v = bVar;
    }

    public c(pb.c cVar) {
        this.f10129u = 6;
        Context context = (Context) cVar.f10310v;
        int iD = ta.f.d(context, "com.google.firebase.crashlytics.unity_version", "string");
        if (iD != 0) {
            this.f10130v = "Unity";
            String string = context.getResources().getString(iD);
            this.f10131w = string;
            String strM = l4.a.m("Unity Editor version is: ", string);
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", strM, null);
                return;
            }
            return;
        }
        if (context.getAssets() != null) {
            try {
                InputStream inputStreamOpen = context.getAssets().open("flutter_assets/NOTICES.Z");
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                this.f10130v = "Flutter";
                this.f10131w = null;
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Development platform is: Flutter", null);
                    return;
                }
                return;
            } catch (IOException unused) {
            }
        }
        this.f10130v = null;
        this.f10131w = null;
    }

    public c(aa.c1 c1Var, int[] iArr) {
        this.f10129u = 14;
        this.f10131w = j0.r(c1Var);
        this.f10130v = iArr;
    }
}
