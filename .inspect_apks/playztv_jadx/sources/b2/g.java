package b2;

import aa.h0;
import aa.h1;
import aa.j0;
import aa.l0;
import aa.m0;
import android.R;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b7.s;
import c7.t;
import com.google.android.gms.internal.measurement.k4;
import com.google.android.material.tabs.TabLayout;
import h4.z;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import n.b3;
import n.n2;
import o2.d0;
import p1.w0;
import s1.b0;
import ta.r;
import ta.u;
import ta.v;
import w1.p;
import wa.a0;
import wa.c1;
import wa.d1;
import wa.f0;
import wa.f1;
import wa.g1;
import wa.j2;
import wa.o0;
import wa.p0;
import wa.q0;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f1739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f1740e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f1741g;

    public /* synthetic */ g(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i) {
        this.f1736a = i;
        this.f1737b = obj;
        this.f1738c = obj2;
        this.f1739d = obj3;
        this.f1740e = obj4;
        this.f = obj5;
        this.f1741g = obj6;
    }

    public static p a(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < i; i10++) {
            String utf = dataInputStream.readUTF();
            int i11 = dataInputStream.readInt();
            if (i11 < 0) {
                throw new IOException(e6.j.l("Invalid value size: ", i11));
            }
            int iMin = Math.min(i11, 10485760);
            byte[] bArrCopyOf = b0.f11649c;
            int i12 = 0;
            while (i12 != i11) {
                int i13 = i12 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i13);
                dataInputStream.readFully(bArrCopyOf, i12, iMin);
                iMin = Math.min(i11 - i13, 10485760);
                i12 = i13;
            }
            map.put(utf, bArrCopyOf);
        }
        return new p(map);
    }

    public static void b(p pVar, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry> setEntrySet = pVar.f13552b.entrySet();
        dataOutputStream.writeInt(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public static p0 c(p0 p0Var, va.f fVar, za.c cVar) {
        o0 o0VarA = p0Var.a();
        String strC = ((va.c) fVar.f13443v).c();
        if (strC != null) {
            o0VarA.f13984e = new c1(strC);
        } else if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "No log data to include with this event.", null);
        }
        List listN = n(((va.d) ((AtomicMarkableReference) ((a2.c) cVar.f14937d).f173v).getReference()).a());
        List listN2 = n(((va.d) ((AtomicMarkableReference) ((a2.c) cVar.f14938e).f173v).getReference()).a());
        if (!listN.isEmpty() || !listN2.isEmpty()) {
            q0 q0Var = (q0) p0Var.f13992c;
            o0VarA.f13982c = new q0(q0Var.f14000a, listN, listN2, q0Var.f14003d, q0Var.f14004e, q0Var.f, q0Var.f14005g);
        }
        return o0VarA.a();
    }

    public static j2 d(p0 p0Var, za.c cVar) {
        List listA = ((va.o) cVar.f).a();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < listA.size(); i++) {
            va.n nVar = (va.n) listA.get(i);
            nVar.getClass();
            d1 d1Var = new d1();
            va.b bVar = (va.b) nVar;
            String str = bVar.f13437e;
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            String str2 = bVar.f13434b;
            if (str2 == null) {
                throw new NullPointerException("Null rolloutId");
            }
            d1Var.f13834a = new f1(str2, str);
            String str3 = bVar.f13435c;
            if (str3 == null) {
                throw new NullPointerException("Null parameterKey");
            }
            d1Var.f13835b = str3;
            String str4 = bVar.f13436d;
            if (str4 == null) {
                throw new NullPointerException("Null parameterValue");
            }
            d1Var.f13836c = str4;
            d1Var.f13837d = bVar.f;
            d1Var.f13838e = (byte) (d1Var.f13838e | 1);
            arrayList.add(d1Var.a());
        }
        if (arrayList.isEmpty()) {
            return p0Var;
        }
        o0 o0VarA = p0Var.a();
        o0VarA.f = new g1(arrayList);
        return o0VarA.a();
    }

    public static boolean f(int[] iArr, int i) {
        for (int i10 : iArr) {
            if (i10 == i) {
                return true;
            }
        }
        return false;
    }

    public static g g(Context context, v vVar, za.c cVar, dd.h hVar, va.f fVar, za.c cVar2, z zVar, s sVar, pb.c cVar3, ta.i iVar, ua.d dVar) {
        r rVar = new r(context, vVar, hVar, zVar, sVar);
        za.a aVar = new za.a(cVar, sVar, iVar);
        xa.a aVar2 = ab.a.f770b;
        t.b(context);
        return new g(rVar, aVar, new ab.a(new ab.d(t.a().c(new a7.a(ab.a.f771c, ab.a.f772d)).a("FIREBASE_CRASHLYTICS_REPORT", new z6.c("json"), ab.a.f773e), sVar.d(), cVar3)), fVar, cVar2, vVar, dVar);
    }

    public static ColorStateList h(Context context, int i) {
        int iC = b3.c(context, g.a.colorControlHighlight);
        return new ColorStateList(new int[][]{b3.f8352b, b3.f8354d, b3.f8353c, b3.f}, new int[]{b3.b(context, g.a.colorButtonNormal), i0.b.b(iC, i), i0.b.b(iC, i), i});
    }

    public static d0 j(w0 w0Var, j0 j0Var, d0 d0Var, p1.c1 c1Var) {
        p1.f1 f1VarW0 = w0Var.w0();
        int iR = w0Var.R();
        Object objL = f1VarW0.p() ? null : f1VarW0.l(iR);
        int iB = (w0Var.o() || f1VarW0.p()) ? -1 : f1VarW0.f(iR, c1Var, false).b(b0.O(w0Var.T0()) - c1Var.f9680e);
        for (int i = 0; i < j0Var.size(); i++) {
            d0 d0Var2 = (d0) j0Var.get(i);
            if (r(d0Var2, objL, w0Var.o(), w0Var.c0(), w0Var.m0(), iB)) {
                return d0Var2;
            }
        }
        if (j0Var.isEmpty() && d0Var != null && r(d0Var, objL, w0Var.o(), w0Var.c0(), w0Var.m0(), iB)) {
            return d0Var;
        }
        return null;
    }

    public static LayerDrawable m(n2 n2Var, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable drawableF = n2Var.f(context, g.e.abc_star_black_48dp);
        Drawable drawableF2 = n2Var.f(context, g.e.abc_star_half_black_48dp);
        if ((drawableF instanceof BitmapDrawable) && drawableF.getIntrinsicWidth() == dimensionPixelSize && drawableF.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableF;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableF.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableF.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableF2 instanceof BitmapDrawable) && drawableF2.getIntrinsicWidth() == dimensionPixelSize && drawableF2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableF2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableF2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableF2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        return layerDrawable;
    }

    public static List n(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            String str2 = (String) entry.getValue();
            if (str2 == null) {
                throw new NullPointerException("Null value");
            }
            arrayList.add(new f0(str, str2));
        }
        Collections.sort(arrayList, new c4.d(20));
        return Collections.unmodifiableList(arrayList);
    }

    public static g p(LayoutInflater layoutInflater) {
        View viewK;
        View viewInflate = layoutInflater.inflate(gc.k.layout_floating_player, (ViewGroup) null, false);
        int i = gc.j.error_lay;
        LinearLayout linearLayout = (LinearLayout) z7.a.k(viewInflate, i);
        if (linearLayout != null) {
            i = gc.j.player_view;
            PlayerView playerView = (PlayerView) z7.a.k(viewInflate, i);
            if (playerView != null) {
                i = gc.j.progress;
                ProgressBar progressBar = (ProgressBar) z7.a.k(viewInflate, i);
                if (progressBar != null) {
                    i = gc.j.refresh_lay_btn;
                    Button button = (Button) z7.a.k(viewInflate, i);
                    if (button != null && (viewK = z7.a.k(viewInflate, (i = gc.j.swipe_binding))) != null) {
                        return new g((RelativeLayout) viewInflate, linearLayout, playerView, progressBar, button, kc.b.j(viewK), 6);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static boolean r(d0 d0Var, Object obj, boolean z2, int i, int i10, int i11) {
        Object obj2 = d0Var.f9090a;
        int i12 = d0Var.f9091b;
        if (!obj2.equals(obj)) {
            return false;
        }
        if (z2 && i12 == i && d0Var.f9092c == i10) {
            return true;
        }
        return !z2 && i12 == -1 && d0Var.f9094e == i11;
    }

    public static void w(Drawable drawable, int i, PorterDuff.Mode mode) {
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = n.t.f8532b;
        }
        drawableMutate.setColorFilter(n.t.c(i, mode));
    }

    public void e(l0 l0Var, d0 d0Var, p1.f1 f1Var) {
        if (d0Var == null) {
            return;
        }
        if (f1Var.b(d0Var.f9090a) != -1) {
            l0Var.v(d0Var, f1Var);
            return;
        }
        p1.f1 f1Var2 = (p1.f1) ((m0) this.f1739d).get(d0Var);
        if (f1Var2 != null) {
            l0Var.v(d0Var, f1Var2);
        }
    }

    public o8.o i(o8.o oVar) {
        return oVar.e(new n4.b(0), new r2.h(9, this));
    }

    public w1.k k(String str) {
        return (w1.k) ((HashMap) this.f1737b).get(str);
    }

    public w1.k l(String str) {
        HashMap map = (HashMap) this.f1737b;
        w1.k kVar = (w1.k) map.get(str);
        if (kVar != null) {
            return kVar;
        }
        SparseArray sparseArray = (SparseArray) this.f1738c;
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            iKeyAt = i;
        }
        w1.k kVar2 = new w1.k(iKeyAt, str, p.f13550c);
        map.put(str, kVar2);
        sparseArray.put(iKeyAt, str);
        ((SparseBooleanArray) this.f1740e).put(iKeyAt, true);
        ((w1.n) this.f).a(kVar2);
        return kVar2;
    }

    public ColorStateList o(Context context, int i) {
        if (i == g.e.abc_edit_text_material) {
            return f0.c.c(context, g.c.abc_tint_edittext);
        }
        if (i == g.e.abc_switch_track_mtrl_alpha) {
            return f0.c.c(context, g.c.abc_tint_switch_track);
        }
        if (i != g.e.abc_switch_thumb_material) {
            if (i == g.e.abc_btn_default_mtrl_shape) {
                return h(context, b3.c(context, g.a.colorButtonNormal));
            }
            if (i == g.e.abc_btn_borderless_material) {
                return h(context, 0);
            }
            if (i == g.e.abc_btn_colored_material) {
                return h(context, b3.c(context, g.a.colorAccent));
            }
            if (i == g.e.abc_spinner_mtrl_am_alpha || i == g.e.abc_spinner_textfield_background_material) {
                return f0.c.c(context, g.c.abc_tint_spinner);
            }
            if (f((int[]) this.f1738c, i)) {
                return b3.d(context, g.a.colorControlNormal);
            }
            if (f((int[]) this.f, i)) {
                return f0.c.c(context, g.c.abc_tint_default);
            }
            if (f((int[]) this.f1741g, i)) {
                return f0.c.c(context, g.c.abc_tint_btn_checkable);
            }
            if (i == g.e.abc_seekbar_thumb_material) {
                return f0.c.c(context, g.c.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListD = b3.d(context, g.a.colorSwitchThumbNormal);
        if (colorStateListD == null || !colorStateListD.isStateful()) {
            iArr[0] = b3.f8352b;
            iArr2[0] = b3.b(context, g.a.colorSwitchThumbNormal);
            iArr[1] = b3.f8355e;
            iArr2[1] = b3.c(context, g.a.colorControlActivated);
            iArr[2] = b3.f;
            iArr2[2] = b3.c(context, g.a.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = b3.f8352b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
            iArr[1] = b3.f8355e;
            iArr2[1] = b3.c(context, g.a.colorControlActivated);
            iArr[2] = b3.f;
            iArr2[2] = colorStateListD.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public void q(long j5) {
        w1.n nVar;
        SparseArray sparseArray = (SparseArray) this.f1738c;
        HashMap map = (HashMap) this.f1737b;
        w1.n nVar2 = (w1.n) this.f;
        nVar2.f(j5);
        w1.n nVar3 = (w1.n) this.f1741g;
        if (nVar3 != null) {
            nVar3.f(j5);
        }
        if (nVar2.c() || (nVar = (w1.n) this.f1741g) == null || !nVar.c()) {
            nVar2.g(map, sparseArray);
        } else {
            ((w1.n) this.f1741g).g(map, sparseArray);
            nVar2.e(map);
        }
        w1.n nVar4 = (w1.n) this.f1741g;
        if (nVar4 != null) {
            nVar4.h();
            this.f1741g = null;
        }
    }

    public void s(String str) {
        SparseArray sparseArray = (SparseArray) this.f1738c;
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.f1740e;
        HashMap map = (HashMap) this.f1737b;
        w1.k kVar = (w1.k) map.get(str);
        if (kVar != null && kVar.f13537c.isEmpty() && kVar.f13538d.isEmpty()) {
            map.remove(str);
            int i = kVar.f13535a;
            boolean z2 = sparseBooleanArray.get(i);
            ((w1.n) this.f).b(kVar, z2);
            if (z2) {
                sparseArray.remove(i);
                sparseBooleanArray.delete(i);
            } else {
                sparseArray.put(i, null);
                ((SparseBooleanArray) this.f1739d).put(i, true);
            }
        }
    }

    public zc.c t() {
        zc.c cVar = new zc.c();
        cVar.f14949y = new LinkedHashMap();
        cVar.f14945u = (ue.o) this.f1737b;
        cVar.f14946v = (String) this.f1738c;
        cVar.f14948x = (ue.v) this.f1740e;
        Map map = (Map) this.f;
        cVar.f14949y = map.isEmpty() ? new LinkedHashMap() : od.t.K(map);
        cVar.f14947w = ((ue.m) this.f1739d).e();
        return cVar;
    }

    public String toString() {
        switch (this.f1736a) {
            case 10:
                Map map = (Map) this.f;
                StringBuilder sb2 = new StringBuilder("Request{method=");
                sb2.append((String) this.f1738c);
                sb2.append(", url=");
                sb2.append((ue.o) this.f1737b);
                ue.m mVar = (ue.m) this.f1739d;
                if (mVar.size() != 0) {
                    sb2.append(", headers=[");
                    Iterator it = mVar.iterator();
                    int i = 0;
                    while (true) {
                        be.a aVar = (be.a) it;
                        if (aVar.hasNext()) {
                            Object next = aVar.next();
                            int i10 = i + 1;
                            if (i < 0) {
                                throw new ArithmeticException("Index overflow has happened.");
                            }
                            nd.f fVar = (nd.f) next;
                            String str = (String) fVar.f8983u;
                            String str2 = (String) fVar.f8984v;
                            if (i > 0) {
                                sb2.append(", ");
                            }
                            sb2.append(str);
                            sb2.append(':');
                            sb2.append(str2);
                            i = i10;
                        } else {
                            sb2.append(']');
                        }
                    }
                }
                if (!map.isEmpty()) {
                    sb2.append(", tags=");
                    sb2.append(map);
                }
                sb2.append('}');
                String string = sb2.toString();
                be.h.d(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            default:
                return super.toString();
        }
    }

    public o8.o u(String str, Executor executor) {
        o8.h hVar;
        ArrayList arrayListB = ((za.a) this.f1738c).b();
        ArrayList arrayList = new ArrayList();
        int size = arrayListB.size();
        int i = 0;
        while (i < size) {
            int i10 = i + 1;
            File file = (File) arrayListB.get(i);
            try {
                xa.a aVar = za.a.f14927g;
                String strE = za.a.e(file);
                aVar.getClass();
                arrayList.add(new ta.a(xa.a.i(strE), file.getName(), file));
            } catch (IOException e10) {
                Log.w("FirebaseCrashlytics", "Could not load report file " + file + "; deleting", e10);
                file.delete();
            }
            i = i10;
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj = arrayList.get(i11);
            i11++;
            ta.a aVar2 = (ta.a) obj;
            if (str == null || str.equals(aVar2.f12349b)) {
                ab.a aVar3 = (ab.a) this.f1739d;
                wa.b0 b0Var = aVar2.f12348a;
                if (b0Var.f == null || b0Var.f13793g == null) {
                    u uVarB = ((v) this.f1741g).b(true);
                    wa.b0 b0Var2 = aVar2.f12348a;
                    String str2 = uVarB.f12430a;
                    a0 a0VarA = b0Var2.a();
                    a0VarA.f13768e = str2;
                    wa.b0 b0VarA = a0VarA.a();
                    String str3 = uVarB.f12431b;
                    a0 a0VarA2 = b0VarA.a();
                    a0VarA2.f = str3;
                    aVar2 = new ta.a(a0VarA2.a(), aVar2.f12349b, aVar2.f12350c);
                }
                boolean z2 = str != null;
                ab.d dVar = aVar3.f774a;
                synchronized (dVar.f) {
                    try {
                        hVar = new o8.h();
                        if (z2) {
                            ((AtomicInteger) dVar.i.f10310v).getAndIncrement();
                            if (dVar.f.size() < dVar.f787e) {
                                qa.c cVar = qa.c.f11167a;
                                cVar.b("Enqueueing report: " + aVar2.f12349b);
                                cVar.b("Queue size: " + dVar.f.size());
                                dVar.f788g.execute(new ab.c(dVar, aVar2, hVar, 0));
                                cVar.b("Closing task for report: " + aVar2.f12349b);
                                hVar.c(aVar2);
                            } else {
                                dVar.a();
                                String str4 = "Dropping report due to queue being full: " + aVar2.f12349b;
                                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                                    Log.d("FirebaseCrashlytics", str4, null);
                                }
                                ((AtomicInteger) dVar.i.f10311w).getAndIncrement();
                                hVar.c(aVar2);
                            }
                        } else {
                            dVar.b(aVar2, hVar);
                        }
                    } finally {
                    }
                }
                arrayList2.add(hVar.f9421a.e(executor, new r2.h(4, this)));
            }
        }
        return t1.x(arrayList2);
    }

    public void v(String str, String str2, Bundle bundle) {
        int i;
        String strEncodeToString;
        int iA;
        PackageInfo packageInfoE;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        ga.g gVar = (ga.g) this.f1737b;
        gVar.a();
        bundle.putString("gmp_app_id", gVar.f5348c.f5360b);
        q0.d dVar = (q0.d) this.f1738c;
        synchronized (dVar) {
            try {
                if (dVar.f10430w == 0 && (packageInfoE = dVar.e("com.google.android.gms")) != null) {
                    dVar.f10430w = packageInfoE.versionCode;
                }
                i = dVar.f10430w;
            } finally {
            }
        }
        bundle.putString("gmsv", Integer.toString(i));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", ((q0.d) this.f1738c).b());
        bundle.putString("app_ver_name", ((q0.d) this.f1738c).c());
        ga.g gVar2 = (ga.g) this.f1737b;
        gVar2.a();
        try {
            strEncodeToString = Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(gVar2.f5347b.getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            strEncodeToString = "[HASH-ERROR]";
        }
        bundle.putString("firebase-app-name-hash", strEncodeToString);
        try {
            String str3 = ((ob.a) t1.d(((ob.c) ((ob.d) this.f1741g)).e())).f9480a;
            if (TextUtils.isEmpty(str3)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", str3);
            }
        } catch (InterruptedException e10) {
            e = e10;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        } catch (ExecutionException e11) {
            e = e11;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        }
        bundle.putString("appid", (String) t1.d(((ob.c) ((ob.d) this.f1741g)).d()));
        bundle.putString("cliv", "fcm-24.0.2");
        lb.g gVar3 = (lb.g) ((nb.b) this.f).get();
        wb.b bVar = (wb.b) ((nb.b) this.f1740e).get();
        if (gVar3 == null || bVar == null || (iA = ((lb.d) gVar3).a()) == 1) {
            return;
        }
        bundle.putString("Firebase-Client-Log-Type", Integer.toString(v.e.c(iA)));
        bundle.putString("Firebase-Client", bVar.a());
    }

    public o8.o x(String str, String str2, Bundle bundle) {
        int i;
        try {
            v(str, str2, bundle);
            p7.b bVar = (p7.b) this.f1739d;
            p7.h hVar = p7.h.f10264w;
            a0.g gVar = bVar.f10252c;
            if (gVar.f() < 12000000) {
                return gVar.h() != 0 ? bVar.a(bundle).f(hVar, new k4(bVar, bundle)) : t1.j(new IOException("MISSING_INSTANCEID_SERVICE"));
            }
            p7.m mVarD = p7.m.d(bVar.f10251b);
            synchronized (mVarD) {
                i = mVarD.f10283u;
                mVarD.f10283u = i + 1;
            }
            return mVarD.e(new p7.l(i, 1, bundle, 1)).e(hVar, p7.d.f10257v);
        } catch (InterruptedException | ExecutionException e10) {
            return t1.j(e10);
        }
    }

    public void y() {
        ((w1.n) this.f).d((HashMap) this.f1737b);
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.f1739d;
        int size = sparseBooleanArray.size();
        for (int i = 0; i < size; i++) {
            ((SparseArray) this.f1738c).remove(sparseBooleanArray.keyAt(i));
        }
        sparseBooleanArray.clear();
        ((SparseBooleanArray) this.f1740e).clear();
    }

    public void z(p1.f1 f1Var) {
        l0 l0Var = new l0(4);
        if (((j0) this.f1738c).isEmpty()) {
            e(l0Var, (d0) this.f, f1Var);
            if (!Objects.equals((d0) this.f1741g, (d0) this.f)) {
                e(l0Var, (d0) this.f1741g, f1Var);
            }
            if (!Objects.equals((d0) this.f1740e, (d0) this.f) && !Objects.equals((d0) this.f1740e, (d0) this.f1741g)) {
                e(l0Var, (d0) this.f1740e, f1Var);
            }
        } else {
            for (int i = 0; i < ((j0) this.f1738c).size(); i++) {
                e(l0Var, (d0) ((j0) this.f1738c).get(i), f1Var);
            }
            if (!((j0) this.f1738c).contains((d0) this.f1740e)) {
                e(l0Var, (d0) this.f1740e, f1Var);
            }
        }
        this.f1739d = l0Var.d();
    }

    public g(ue.o oVar, String str, ue.m mVar, ue.v vVar, Map map) {
        this.f1736a = 10;
        be.h.e(oVar, "url");
        be.h.e(str, "method");
        this.f1737b = oVar;
        this.f1738c = str;
        this.f1739d = mVar;
        this.f1740e = vVar;
        this.f = map;
    }

    public g(LinearLayout linearLayout, LinearLayout linearLayout2, FragmentContainerView fragmentContainerView, TextView textView, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TabLayout tabLayout, LinearLayout linearLayout3) {
        this.f1736a = 5;
        this.f1737b = linearLayout2;
        this.f1738c = textView;
        this.f1739d = recyclerView;
        this.f1740e = swipeRefreshLayout;
        this.f = tabLayout;
        this.f1741g = linearLayout3;
    }

    public g(ConstraintLayout constraintLayout, Button button, Button button2, Button button3, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        this.f1736a = 4;
        this.f1737b = button;
        this.f1738c = button2;
        this.f1739d = button3;
        this.f1740e = imageView;
        this.f = linearLayout;
        this.f1741g = textView;
    }

    public g() {
        this.f1736a = 7;
        this.f1737b = new int[]{g.e.abc_textfield_search_default_mtrl_alpha, g.e.abc_textfield_default_mtrl_alpha, g.e.abc_ab_share_pack_mtrl_alpha};
        this.f1738c = new int[]{g.e.abc_ic_commit_search_api_mtrl_alpha, g.e.abc_seekbar_tick_mark_material, g.e.abc_ic_menu_share_mtrl_alpha, g.e.abc_ic_menu_copy_mtrl_am_alpha, g.e.abc_ic_menu_cut_mtrl_alpha, g.e.abc_ic_menu_selectall_mtrl_alpha, g.e.abc_ic_menu_paste_mtrl_am_alpha};
        this.f1739d = new int[]{g.e.abc_textfield_activated_mtrl_alpha, g.e.abc_textfield_search_activated_mtrl_alpha, g.e.abc_cab_background_top_mtrl_alpha, g.e.abc_text_cursor_material, g.e.abc_text_select_handle_left_mtrl, g.e.abc_text_select_handle_middle_mtrl, g.e.abc_text_select_handle_right_mtrl};
        this.f1740e = new int[]{g.e.abc_popup_background_mtrl_mult, g.e.abc_cab_background_internal_bg, g.e.abc_menu_hardkey_panel_mtrl_mult};
        this.f = new int[]{g.e.abc_tab_indicator_material, g.e.abc_textfield_search_material};
        this.f1741g = new int[]{g.e.abc_btn_check_material, g.e.abc_btn_radio_material, g.e.abc_btn_check_material_anim, g.e.abc_btn_radio_material_anim};
    }

    public g(r rVar, za.a aVar, ab.a aVar2, va.f fVar, za.c cVar, v vVar, ua.d dVar) {
        this.f1736a = 8;
        this.f1737b = rVar;
        this.f1738c = aVar;
        this.f1739d = aVar2;
        this.f1740e = fVar;
        this.f = cVar;
        this.f1741g = vVar;
    }

    public g(u1.a aVar, File file) {
        this.f1736a = 11;
        this.f1737b = new HashMap();
        this.f1738c = new SparseArray();
        this.f1739d = new SparseBooleanArray();
        this.f1740e = new SparseBooleanArray();
        w1.l lVar = new w1.l(aVar);
        w1.m mVar = new w1.m(new File(file, "cached_content_index.exi"));
        this.f = lVar;
        this.f1741g = mVar;
    }

    public g(ga.g gVar, q0.d dVar, nb.b bVar, nb.b bVar2, ob.d dVar2) {
        this.f1736a = 9;
        gVar.a();
        p7.b bVar3 = new p7.b(gVar.f5346a);
        this.f1737b = gVar;
        this.f1738c = dVar;
        this.f1739d = bVar3;
        this.f1740e = bVar;
        this.f = bVar2;
        this.f1741g = dVar2;
    }

    public g(xe.c cVar) {
        this.f1736a = 1;
        be.h.e(cVar, "taskRunner");
        this.f1737b = cVar;
        this.f1741g = bf.h.f2077a;
    }

    public g(p1.c1 c1Var) {
        this.f1736a = 0;
        this.f1737b = c1Var;
        h0 h0Var = j0.f690v;
        this.f1738c = aa.c1.f650y;
        this.f1739d = h1.A;
    }
}
