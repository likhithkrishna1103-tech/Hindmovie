package c2;

import android.R;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.tabs.TabLayout;
import f9.v1;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import k4.r0;
import kf.x;
import o.f3;
import o.o2;
import qb.b0;
import qb.c1;
import qb.d1;
import qb.f0;
import qb.f1;
import qb.g1;
import qb.j2;
import qb.o0;
import qb.p0;
import qb.q0;
import s2.c0;
import ua.e1;
import ua.g0;
import ua.i0;
import ua.k0;
import ua.z0;
import v1.w0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f2036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f2037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f2038e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f2039g;

    public /* synthetic */ o(ViewGroup viewGroup, LinearLayout linearLayout, TextView textView, TextView textView2, ViewGroup viewGroup2, View view, Object obj, int i) {
        this.f2034a = i;
        this.f2035b = linearLayout;
        this.f2036c = textView;
        this.f2037d = textView2;
        this.f2038e = viewGroup2;
        this.f = view;
        this.f2039g = obj;
    }

    public static q a(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < i; i10++) {
            String utf = dataInputStream.readUTF();
            int i11 = dataInputStream.readInt();
            if (i11 < 0) {
                throw new IOException(l0.e.g(i11, "Invalid value size: "));
            }
            int iMin = Math.min(i11, 10485760);
            byte[] bArrCopyOf = a0.f14553c;
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
        return new q(map);
    }

    public static void b(q qVar, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry> setEntrySet = qVar.f2042b.entrySet();
        dataOutputStream.writeInt(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public static p0 c(p0 p0Var, pb.e eVar, tb.c cVar, Map map) {
        Map mapUnmodifiableMap;
        o0 o0VarA = p0Var.a();
        String strH = ((pb.c) eVar.f10157w).h();
        if (strH != null) {
            o0VarA.f10687e = new c1(strH);
        } else if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "No log data to include with this event.", null);
        }
        com.bumptech.glide.l lVar = (com.bumptech.glide.l) cVar.f11986y;
        if (map.isEmpty()) {
            mapUnmodifiableMap = ((pb.d) ((AtomicMarkableReference) lVar.f2223w).getReference()).a();
        } else {
            HashMap map2 = new HashMap(((pb.d) ((AtomicMarkableReference) lVar.f2223w).getReference()).a());
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                String strB = pb.d.b(1024, (String) entry.getKey());
                if (map2.size() < 64 || map2.containsKey(strB)) {
                    map2.put(strB, pb.d.b(1024, (String) entry.getValue()));
                } else {
                    i++;
                }
            }
            if (i > 0) {
                Log.w("FirebaseCrashlytics", "Ignored " + i + " keys when adding event specific keys. Maximum allowable: 1024", null);
            }
            mapUnmodifiableMap = Collections.unmodifiableMap(map2);
        }
        List listO = o(mapUnmodifiableMap);
        List listO2 = o(((pb.d) ((AtomicMarkableReference) ((com.bumptech.glide.l) cVar.f11987z).f2223w).getReference()).a());
        if (!listO.isEmpty() || !listO2.isEmpty()) {
            q0 q0Var = (q0) p0Var.f10695c;
            o0VarA.f10685c = new q0(q0Var.f10703a, listO, listO2, q0Var.f10706d, q0Var.f10707e, q0Var.f, q0Var.f10708g);
        }
        return o0VarA.a();
    }

    public static j2 d(p0 p0Var, tb.c cVar) {
        List listA = ((of.t) cVar.A).a();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < listA.size(); i++) {
            pb.m mVar = (pb.m) listA.get(i);
            mVar.getClass();
            d1 d1Var = new d1();
            pb.b bVar = (pb.b) mVar;
            String str = bVar.f10151e;
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            String str2 = bVar.f10148b;
            if (str2 == null) {
                throw new NullPointerException("Null rolloutId");
            }
            d1Var.f10537a = new f1(str2, str);
            String str3 = bVar.f10149c;
            if (str3 == null) {
                throw new NullPointerException("Null parameterKey");
            }
            d1Var.f10538b = str3;
            String str4 = bVar.f10150d;
            if (str4 == null) {
                throw new NullPointerException("Null parameterValue");
            }
            d1Var.f10539c = str4;
            d1Var.f10540d = bVar.f;
            d1Var.f10541e = (byte) (d1Var.f10541e | 1);
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

    public static String g(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bArr = new byte[8192];
            } finally {
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        while (true) {
            int i = bufferedInputStream.read(bArr);
            if (i == -1) {
                String string = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                byteArrayOutputStream.close();
                bufferedInputStream.close();
                return string;
            }
            byteArrayOutputStream.write(bArr, 0, i);
            bufferedInputStream.close();
            throw th;
        }
    }

    public static o h(Context context, nb.v vVar, tb.c cVar, hd.e eVar, pb.e eVar2, tb.c cVar2, vb.b bVar, d8.j jVar, nb.w wVar, nb.i iVar, ob.c cVar3) {
        nb.q qVar = new nb.q(context, vVar, eVar, bVar, jVar);
        tb.a aVar = new tb.a(cVar, jVar, iVar);
        rb.a aVar2 = ub.a.f12416b;
        x7.p.b(context);
        return new o(qVar, aVar, new ub.a(new ub.c(x7.p.a().c(new v7.a(ub.a.f12417c, ub.a.f12418d)).a("FIREBASE_CRASHLYTICS_REPORT", new u7.c("json"), ub.a.f12419e), jVar.d(), wVar)), eVar2, cVar2, vVar, cVar3);
    }

    public static ColorStateList i(Context context, int i) {
        int iC = f3.c(context, g.a.colorControlHighlight);
        return new ColorStateList(new int[][]{f3.f9220b, f3.f9222d, f3.f9221c, f3.f}, new int[]{f3.b(context, g.a.colorButtonNormal), l0.b.b(iC, i), l0.b.b(iC, i), i});
    }

    public static c0 k(w0 w0Var, i0 i0Var, c0 c0Var, v1.c1 c1Var) {
        v1.f1 f1VarV0 = w0Var.v0();
        int iO = w0Var.O();
        Object objL = f1VarV0.p() ? null : f1VarV0.l(iO);
        int iB = (w0Var.l() || f1VarV0.p()) ? -1 : f1VarV0.f(iO, c1Var, false).b(a0.O(w0Var.V0()) - c1Var.f12620e);
        for (int i = 0; i < i0Var.size(); i++) {
            c0 c0Var2 = (c0) i0Var.get(i);
            if (r(c0Var2, objL, w0Var.l(), w0Var.X(), w0Var.k0(), iB)) {
                return c0Var2;
            }
        }
        if (i0Var.isEmpty() && c0Var != null && r(c0Var, objL, w0Var.l(), w0Var.X(), w0Var.k0(), iB)) {
            return c0Var;
        }
        return null;
    }

    public static LayerDrawable n(o2 o2Var, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable drawableF = o2Var.f(context, g.e.abc_star_black_48dp);
        Drawable drawableF2 = o2Var.f(context, g.e.abc_star_half_black_48dp);
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

    public static List o(Map map) {
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
        Collections.sort(arrayList, new g4.d(7));
        return Collections.unmodifiableList(arrayList);
    }

    public static boolean r(c0 c0Var, Object obj, boolean z10, int i, int i10, int i11) {
        Object obj2 = c0Var.f11156a;
        int i12 = c0Var.f11157b;
        if (!obj2.equals(obj)) {
            return false;
        }
        if (z10 && i12 == i && c0Var.f11158c == i10) {
            return true;
        }
        return !z10 && i12 == -1 && c0Var.f11160e == i11;
    }

    public static void y(Drawable drawable, int i, PorterDuff.Mode mode) {
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = o.r.f9335b;
        }
        drawableMutate.setColorFilter(o.r.c(i, mode));
    }

    public void A() {
        ((n) this.f).b((HashMap) this.f2035b);
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.f2037d;
        int size = sparseBooleanArray.size();
        for (int i = 0; i < size; i++) {
            ((SparseArray) this.f2036c).remove(sparseBooleanArray.keyAt(i));
        }
        sparseBooleanArray.clear();
        ((SparseBooleanArray) this.f2038e).clear();
    }

    public void B(v1.f1 f1Var) {
        f3.a aVar = new f3.a(4);
        if (((i0) this.f2036c).isEmpty()) {
            e(aVar, (c0) this.f, f1Var);
            if (!Objects.equals((c0) this.f2039g, (c0) this.f)) {
                e(aVar, (c0) this.f2039g, f1Var);
            }
            if (!Objects.equals((c0) this.f2038e, (c0) this.f) && !Objects.equals((c0) this.f2038e, (c0) this.f2039g)) {
                e(aVar, (c0) this.f2038e, f1Var);
            }
        } else {
            for (int i = 0; i < ((i0) this.f2036c).size(); i++) {
                e(aVar, (c0) ((i0) this.f2036c).get(i), f1Var);
            }
            if (!((i0) this.f2036c).contains((c0) this.f2038e)) {
                e(aVar, (c0) this.f2038e, f1Var);
            }
        }
        this.f2037d = aVar.c();
    }

    public void e(f3.a aVar, c0 c0Var, v1.f1 f1Var) {
        if (c0Var == null) {
            return;
        }
        if (f1Var.b(c0Var.f11156a) != -1) {
            aVar.u(c0Var, f1Var);
            return;
        }
        v1.f1 f1Var2 = (v1.f1) ((k0) this.f2037d).get(c0Var);
        if (f1Var2 != null) {
            aVar.u(c0Var, f1Var2);
        }
    }

    public j9.p j(j9.p pVar) {
        return pVar.e(new p.a(1), new nc.l(this));
    }

    public k l(String str) {
        return (k) ((HashMap) this.f2035b).get(str);
    }

    public k m(String str) {
        HashMap map = (HashMap) this.f2035b;
        k kVar = (k) map.get(str);
        if (kVar != null) {
            return kVar;
        }
        SparseArray sparseArray = (SparseArray) this.f2036c;
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            iKeyAt = i;
        }
        k kVar2 = new k(iKeyAt, str, q.f2040c);
        map.put(str, kVar2);
        sparseArray.put(iKeyAt, str);
        ((SparseBooleanArray) this.f2038e).put(iKeyAt, true);
        ((n) this.f).c(kVar2);
        return kVar2;
    }

    public ColorStateList p(Context context, int i) {
        if (i == g.e.abc_edit_text_material) {
            return i0.c.c(context, g.c.abc_tint_edittext);
        }
        if (i == g.e.abc_switch_track_mtrl_alpha) {
            return i0.c.c(context, g.c.abc_tint_switch_track);
        }
        if (i != g.e.abc_switch_thumb_material) {
            if (i == g.e.abc_btn_default_mtrl_shape) {
                return i(context, f3.c(context, g.a.colorButtonNormal));
            }
            if (i == g.e.abc_btn_borderless_material) {
                return i(context, 0);
            }
            if (i == g.e.abc_btn_colored_material) {
                return i(context, f3.c(context, g.a.colorAccent));
            }
            if (i == g.e.abc_spinner_mtrl_am_alpha || i == g.e.abc_spinner_textfield_background_material) {
                return i0.c.c(context, g.c.abc_tint_spinner);
            }
            if (f((int[]) this.f2036c, i)) {
                return f3.d(context, g.a.colorControlNormal);
            }
            if (f((int[]) this.f, i)) {
                return i0.c.c(context, g.c.abc_tint_default);
            }
            if (f((int[]) this.f2039g, i)) {
                return i0.c.c(context, g.c.abc_tint_btn_checkable);
            }
            if (i == g.e.abc_seekbar_thumb_material) {
                return i0.c.c(context, g.c.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListD = f3.d(context, g.a.colorSwitchThumbNormal);
        if (colorStateListD == null || !colorStateListD.isStateful()) {
            iArr[0] = f3.f9220b;
            iArr2[0] = f3.b(context, g.a.colorSwitchThumbNormal);
            iArr[1] = f3.f9223e;
            iArr2[1] = f3.c(context, g.a.colorControlActivated);
            iArr[2] = f3.f;
            iArr2[2] = f3.c(context, g.a.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = f3.f9220b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
            iArr[1] = f3.f9223e;
            iArr2[1] = f3.c(context, g.a.colorControlActivated);
            iArr[2] = f3.f;
            iArr2[2] = colorStateListD.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public void q(long j4) {
        n nVar;
        SparseArray sparseArray = (SparseArray) this.f2036c;
        HashMap map = (HashMap) this.f2035b;
        n nVar2 = (n) this.f;
        nVar2.e(j4);
        n nVar3 = (n) this.f2039g;
        if (nVar3 != null) {
            nVar3.e(j4);
        }
        if (nVar2.a() || (nVar = (n) this.f2039g) == null || !nVar.a()) {
            nVar2.g(map, sparseArray);
        } else {
            ((n) this.f2039g).g(map, sparseArray);
            nVar2.d(map);
        }
        n nVar4 = (n) this.f2039g;
        if (nVar4 != null) {
            nVar4.h();
            this.f2039g = null;
        }
    }

    public ag.l s() throws IOException {
        uf.f fVar = uf.f.f12506a;
        Object obj = uf.f.f12506a;
        uf.e eVar = obj != null ? (uf.e) obj : null;
        Context contextB = eVar != null ? eVar.b() : null;
        AssetManager assets = contextB != null ? contextB.getAssets() : null;
        if (assets == null) {
            if (Build.FINGERPRINT == null) {
                throw new IOException("Platform applicationContext not initialized. Possibly running Android unit test without Robolectric. Android tests should run with Robolectric and call OkHttp.initialize before test");
            }
            throw new IOException("Platform applicationContext not initialized. Startup Initializer possibly disabled, call OkHttp.initialize before test.");
        }
        InputStream inputStreamOpen = assets.open((String) this.f2039g);
        ge.i.d(inputStreamOpen, "open(...)");
        return vf.g.Y(inputStreamOpen);
    }

    public void t(String str) {
        SparseArray sparseArray = (SparseArray) this.f2036c;
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.f2038e;
        HashMap map = (HashMap) this.f2035b;
        k kVar = (k) map.get(str);
        if (kVar != null && kVar.f2021c.isEmpty() && kVar.f2022d.isEmpty()) {
            map.remove(str);
            int i = kVar.f2019a;
            boolean z10 = sparseBooleanArray.get(i);
            ((n) this.f).f(kVar, z10);
            if (z10) {
                sparseArray.remove(i);
                sparseBooleanArray.delete(i);
            } else {
                sparseArray.put(i, null);
                ((SparseBooleanArray) this.f2037d).put(i, true);
            }
        }
    }

    public String toString() {
        switch (this.f2034a) {
            case 2:
                lf.a aVar = (lf.a) this.f;
                StringBuilder sb = new StringBuilder(32);
                sb.append("Request{method=");
                sb.append((String) this.f2036c);
                sb.append(", url=");
                sb.append((kf.q) this.f2035b);
                kf.p pVar = (kf.p) this.f2037d;
                if (pVar.size() != 0) {
                    sb.append(", headers=[");
                    Iterator it = pVar.iterator();
                    int i = 0;
                    while (true) {
                        ge.b bVar = (ge.b) it;
                        if (bVar.hasNext()) {
                            Object next = bVar.next();
                            int i10 = i + 1;
                            if (i < 0) {
                                sd.k.e0();
                                throw null;
                            }
                            rd.f fVar = (rd.f) next;
                            String str = (String) fVar.f10993v;
                            String str2 = (String) fVar.f10994w;
                            if (i > 0) {
                                sb.append(", ");
                            }
                            sb.append(str);
                            sb.append(':');
                            if (lf.d.j(str)) {
                                str2 = "██";
                            }
                            sb.append(str2);
                            i = i10;
                        } else {
                            sb.append(']');
                        }
                    }
                }
                if (!ge.i.a(aVar, lf.a.f7956a)) {
                    sb.append(", tags=");
                    sb.append(aVar);
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public dd.c u() {
        dd.c cVar = new dd.c(false);
        cVar.f3672w = (kf.q) this.f2035b;
        cVar.f3673x = (String) this.f2036c;
        cVar.f3675z = (x) this.f2038e;
        cVar.A = (lf.a) this.f;
        cVar.f3674y = ((kf.p) this.f2037d).c();
        return cVar;
    }

    public void v() {
        try {
            ag.q qVarD = vf.g.d(s());
            try {
                ag.h hVarK = qVarD.k(qVarD.readInt());
                ag.h hVarK2 = qVarD.k(qVarD.readInt());
                qVarD.close();
                synchronized (this) {
                    ge.i.b(hVarK);
                    this.f2037d = hVarK;
                    ge.i.b(hVarK2);
                    this.f2038e = hVarK2;
                }
            } finally {
            }
        } finally {
            ((CountDownLatch) this.f2036c).countDown();
        }
    }

    public j9.p w(String str, Executor executor) {
        j9.i iVar;
        ArrayList arrayListB = ((tb.a) this.f2036c).b();
        ArrayList arrayList = new ArrayList();
        int size = arrayListB.size();
        int i = 0;
        while (i < size) {
            int i10 = i + 1;
            File file = (File) arrayListB.get(i);
            try {
                rb.a aVar = tb.a.f11976g;
                String strE = tb.a.e(file);
                aVar.getClass();
                arrayList.add(new nb.a(rb.a.i(strE), file.getName(), file));
            } catch (IOException e9) {
                Log.w("FirebaseCrashlytics", "Could not load report file " + file + "; deleting", e9);
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
            nb.a aVar2 = (nb.a) obj;
            if (str == null || str.equals(aVar2.f8923b)) {
                ub.a aVar3 = (ub.a) this.f2037d;
                b0 b0Var = aVar2.f8922a;
                if (b0Var.f == null || b0Var.f10496g == null) {
                    nb.u uVarB = ((nb.v) this.f2039g).b(true);
                    b0 b0Var2 = aVar2.f8922a;
                    String str2 = uVarB.f9006a;
                    qb.a0 a0VarA = b0Var2.a();
                    a0VarA.f10471e = str2;
                    b0 b0VarA = a0VarA.a();
                    String str3 = uVarB.f9007b;
                    qb.a0 a0VarA2 = b0VarA.a();
                    a0VarA2.f = str3;
                    aVar2 = new nb.a(a0VarA2.a(), aVar2.f8923b, aVar2.f8924c);
                }
                boolean z10 = str != null;
                ub.c cVar = aVar3.f12420a;
                synchronized (cVar.f) {
                    try {
                        iVar = new j9.i();
                        if (z10) {
                            ((AtomicInteger) cVar.i.f9016w).getAndIncrement();
                            if (cVar.f.size() < cVar.f12429e) {
                                kb.c cVar2 = kb.c.f7396a;
                                cVar2.b("Enqueueing report: " + aVar2.f8923b);
                                cVar2.b("Queue size: " + cVar.f.size());
                                cVar.f12430g.execute(new v1(cVar, aVar2, iVar, 13));
                                cVar2.b("Closing task for report: " + aVar2.f8923b);
                                iVar.c(aVar2);
                            } else {
                                cVar.a();
                                String str4 = "Dropping report due to queue being full: " + aVar2.f8923b;
                                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                                    Log.d("FirebaseCrashlytics", str4, null);
                                }
                                ((AtomicInteger) cVar.i.f9017x).getAndIncrement();
                                iVar.c(aVar2);
                            }
                        } else {
                            cVar.b(aVar2, iVar);
                        }
                    } finally {
                    }
                }
                arrayList2.add(iVar.f6688a.e(executor, new r0(27, this)));
            }
        }
        return vf.g.b0(arrayList2);
    }

    public void x(String str, String str2, Bundle bundle) {
        int i;
        String strEncodeToString;
        int iA;
        PackageInfo packageInfoF;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        ab.g gVar = (ab.g) this.f2035b;
        gVar.a();
        bundle.putString("gmp_app_id", gVar.f392c.f404b);
        t0.d dVar = (t0.d) this.f2036c;
        synchronized (dVar) {
            try {
                if (dVar.f11739x == 0 && (packageInfoF = dVar.f("com.google.android.gms")) != null) {
                    dVar.f11739x = packageInfoF.versionCode;
                }
                i = dVar.f11739x;
            } finally {
            }
        }
        bundle.putString("gmsv", Integer.toString(i));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", ((t0.d) this.f2036c).a());
        bundle.putString("app_ver_name", ((t0.d) this.f2036c).b());
        ab.g gVar2 = (ab.g) this.f2035b;
        gVar2.a();
        try {
            strEncodeToString = Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(gVar2.f391b.getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            strEncodeToString = "[HASH-ERROR]";
        }
        bundle.putString("firebase-app-name-hash", strEncodeToString);
        try {
            String str3 = ((ic.a) vf.g.b(((ic.c) ((ic.d) this.f2039g)).e())).f6414a;
            if (TextUtils.isEmpty(str3)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", str3);
            }
        } catch (InterruptedException e9) {
            e = e9;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        } catch (ExecutionException e10) {
            e = e10;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
        }
        bundle.putString("appid", (String) vf.g.b(((ic.c) ((ic.d) this.f2039g)).d()));
        bundle.putString("cliv", "fcm-25.0.1");
        fc.g gVar3 = (fc.g) ((hc.b) this.f).get();
        pc.b bVar = (pc.b) ((hc.b) this.f2038e).get();
        if (gVar3 == null || bVar == null || (iA = ((fc.d) gVar3).a()) == 1) {
            return;
        }
        bundle.putString("Firebase-Client-Log-Type", Integer.toString(y.e.c(iA)));
        bundle.putString("Firebase-Client", bVar.a());
    }

    public j9.p z(String str, String str2, Bundle bundle) {
        int i;
        try {
            x(str, str2, bundle);
            k8.b bVar = (k8.b) this.f2037d;
            k8.h hVar = k8.h.f7261x;
            b2.q qVar = bVar.f7249c;
            if (qVar.f() < 12000000) {
                return qVar.g() != 0 ? bVar.a(bundle).f(hVar, new i2.k(bVar, bundle)) : vf.g.z(new IOException("MISSING_INSTANCEID_SERVICE"));
            }
            k8.m mVarD = k8.m.d(bVar.f7248b);
            synchronized (mVarD) {
                i = mVarD.f7279v;
                mVarD.f7279v = i + 1;
            }
            return mVarD.e(new k8.l(i, 1, bundle, 1)).e(hVar, k8.d.f7254w);
        } catch (InterruptedException | ExecutionException e9) {
            return vf.g.z(e9);
        }
    }

    public /* synthetic */ o(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i) {
        this.f2034a = i;
        this.f2035b = obj;
        this.f2036c = obj2;
        this.f2037d = obj3;
        this.f2038e = obj4;
        this.f = obj5;
        this.f2039g = obj6;
    }

    public o(dd.c cVar) {
        this.f2034a = 2;
        kf.q qVar = (kf.q) cVar.f3672w;
        if (qVar != null) {
            this.f2035b = qVar;
            this.f2036c = (String) cVar.f3673x;
            this.f2037d = ((kf.o) cVar.f3674y).b();
            this.f2038e = (x) cVar.f3675z;
            this.f = (lf.a) cVar.A;
            return;
        }
        throw new IllegalStateException("url == null");
    }

    public o(LinearLayout linearLayout, ImageView imageView, FragmentContainerView fragmentContainerView, TextView textView, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TabLayout tabLayout, LinearLayout linearLayout2) {
        this.f2034a = 9;
        this.f2035b = imageView;
        this.f2036c = textView;
        this.f2037d = recyclerView;
        this.f2038e = swipeRefreshLayout;
        this.f = tabLayout;
        this.f2039g = linearLayout2;
    }

    public o(int i) {
        this.f2034a = i;
        switch (i) {
            case 11:
                this.f2034a = 11;
                this.f2035b = new AtomicBoolean(false);
                this.f2036c = new CountDownLatch(1);
                this.f2039g = "PublicSuffixDatabase.list";
                break;
            default:
                this.f2035b = new int[]{g.e.abc_textfield_search_default_mtrl_alpha, g.e.abc_textfield_default_mtrl_alpha, g.e.abc_ab_share_pack_mtrl_alpha};
                this.f2036c = new int[]{g.e.abc_ic_commit_search_api_mtrl_alpha, g.e.abc_seekbar_tick_mark_material, g.e.abc_ic_menu_share_mtrl_alpha, g.e.abc_ic_menu_copy_mtrl_am_alpha, g.e.abc_ic_menu_cut_mtrl_alpha, g.e.abc_ic_menu_selectall_mtrl_alpha, g.e.abc_ic_menu_paste_mtrl_am_alpha};
                this.f2037d = new int[]{g.e.abc_textfield_activated_mtrl_alpha, g.e.abc_textfield_search_activated_mtrl_alpha, g.e.abc_cab_background_top_mtrl_alpha, g.e.abc_text_cursor_material, g.e.abc_text_select_handle_left_mtrl, g.e.abc_text_select_handle_middle_mtrl, g.e.abc_text_select_handle_right_mtrl};
                this.f2038e = new int[]{g.e.abc_popup_background_mtrl_mult, g.e.abc_cab_background_internal_bg, g.e.abc_menu_hardkey_panel_mtrl_mult};
                this.f = new int[]{g.e.abc_tab_indicator_material, g.e.abc_textfield_search_material};
                this.f2039g = new int[]{g.e.abc_btn_check_material, g.e.abc_btn_radio_material, g.e.abc_btn_check_material_anim, g.e.abc_btn_radio_material_anim};
                break;
        }
    }

    public o(nb.q qVar, tb.a aVar, ub.a aVar2, pb.e eVar, tb.c cVar, nb.v vVar, ob.c cVar2) {
        this.f2034a = 3;
        this.f2035b = qVar;
        this.f2036c = aVar;
        this.f2037d = aVar2;
        this.f2038e = eVar;
        this.f = cVar;
        this.f2039g = vVar;
    }

    public o(a2.b bVar, File file) {
        this.f2034a = 0;
        this.f2035b = new HashMap();
        this.f2036c = new SparseArray();
        this.f2037d = new SparseBooleanArray();
        this.f2038e = new SparseBooleanArray();
        l lVar = new l(bVar);
        m mVar = new m(new File(file, "cached_content_index.exi"));
        this.f = lVar;
        this.f2039g = mVar;
    }

    public o(ab.g gVar, t0.d dVar, hc.b bVar, hc.b bVar2, ic.d dVar2) {
        this.f2034a = 4;
        gVar.a();
        k8.b bVar3 = new k8.b(gVar.f390a);
        this.f2035b = gVar;
        this.f2036c = dVar;
        this.f2037d = bVar3;
        this.f2038e = bVar;
        this.f = bVar2;
        this.f2039g = dVar2;
    }

    public o(v1.c1 c1Var) {
        this.f2034a = 1;
        this.f2035b = c1Var;
        g0 g0Var = i0.f12341w;
        this.f2036c = z0.f12413z;
        this.f2037d = e1.B;
    }
}
