package kc;

import a0.f;
import android.content.ClipDescription;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import c6.i;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.google.firebase.messaging.FirebaseMessagingService;
import e6.b0;
import gc.j;
import gc.k;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import l6.v;
import n.a1;
import n.s0;
import n.t;
import o5.n;
import o8.o;
import s0.g;
import ue.s;
import v1.h;
import w2.l;
import w2.r;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements o8.c, q6.a, ra.b, ra.a, g, v1.g, p0.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7619u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f7620v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f7621w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f7622x;

    public /* synthetic */ b(int i) {
        this.f7619u = i;
    }

    public static b C(Context context, AttributeSet attributeSet, int[] iArr) {
        return new b(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static b D(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new b(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    public static b j(View view) {
        int i = j.swipeImageView;
        ImageView imageView = (ImageView) z7.a.k(view, i);
        if (imageView != null) {
            CardView cardView = (CardView) view;
            int i10 = j.swipeTextView;
            TextView textView = (TextView) z7.a.k(view, i10);
            if (textView != null) {
                return new b(imageView, cardView, textView, 2);
            }
            i = i10;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static String m(String str, HashMap map) {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        sb2.append((String) entry.getKey());
        sb2.append("=");
        sb2.append(entry.getValue() != null ? URLEncoder.encode((String) entry.getValue(), "UTF-8") : "");
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb2.append("&");
            sb2.append((String) entry2.getKey());
            sb2.append("=");
            sb2.append(entry2.getValue() != null ? URLEncoder.encode((String) entry2.getValue(), "UTF-8") : "");
        }
        String string = sb2.toString();
        if (string.isEmpty()) {
            return str;
        }
        if (str.contains("?")) {
            if (!str.endsWith("&")) {
                string = "&".concat(string);
            }
            return e6.j.m(str, string);
        }
        return str + "?" + string;
    }

    public static b y(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(k.dialog_floating_player, (ViewGroup) null, false);
        int i = j.enable_sw;
        Switch r12 = (Switch) z7.a.k(viewInflate, i);
        if (r12 != null) {
            i = j.sp;
            Spinner spinner = (Spinner) z7.a.k(viewInflate, i);
            if (spinner != null) {
                return new b((LinearLayout) viewInflate, r12, spinner, 0);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // o8.c
    public void A(o oVar) {
        p7.b bVar = (p7.b) this.f7620v;
        String str = (String) this.f7621w;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f7622x;
        synchronized (bVar.f10250a) {
            bVar.f10250a.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    public boolean B(int i, f fVar, x.e eVar) {
        y.b bVar = (y.b) this.f7621w;
        int[] iArr = eVar.f14149p0;
        int[] iArr2 = eVar.f14153t;
        bVar.f14373a = iArr[0];
        bVar.f14374b = iArr[1];
        bVar.f14375c = eVar.q();
        bVar.f14376d = eVar.k();
        bVar.i = false;
        bVar.f14380j = i;
        boolean z2 = bVar.f14373a == 3;
        boolean z10 = bVar.f14374b == 3;
        boolean z11 = z2 && eVar.W > 0.0f;
        boolean z12 = z10 && eVar.W > 0.0f;
        if (z11 && iArr2[0] == 4) {
            bVar.f14373a = 1;
        }
        if (z12 && iArr2[1] == 4) {
            bVar.f14374b = 1;
        }
        fVar.b(eVar, bVar);
        eVar.O(bVar.f14377e);
        eVar.L(bVar.f);
        eVar.E = bVar.f14379h;
        eVar.I(bVar.f14378g);
        bVar.f14380j = 0;
        return bVar.i;
    }

    public void E() {
        ((TypedArray) this.f7621w).recycle();
    }

    public void F(Map map) {
        p2.c cVar = (p2.c) this.f7620v;
        synchronized (cVar) {
            cVar.f10131w = null;
            ((HashMap) cVar.f10130v).clear();
            ((HashMap) cVar.f10130v).putAll(map);
        }
    }

    public void G(x.f fVar, int i, int i10, int i11) {
        int i12 = fVar.f14124b0;
        int i13 = fVar.f14126c0;
        fVar.f14124b0 = 0;
        fVar.f14126c0 = 0;
        fVar.O(i10);
        fVar.L(i11);
        if (i12 < 0) {
            fVar.f14124b0 = 0;
        } else {
            fVar.f14124b0 = i12;
        }
        if (i13 < 0) {
            fVar.f14126c0 = 0;
        } else {
            fVar.f14126c0 = i13;
        }
        x.f fVar2 = (x.f) this.f7622x;
        fVar2.f14163t0 = i;
        fVar2.U();
    }

    public void J() {
        synchronized (this) {
            ((AtomicInteger) this.f7621w).decrementAndGet();
            if (((AtomicInteger) this.f7621w).get() < 0) {
                throw new IllegalStateException("Unbalanced call to unblock() detected.");
            }
        }
    }

    public void K(x.f fVar) {
        ArrayList arrayList = (ArrayList) this.f7620v;
        arrayList.clear();
        int size = fVar.f14160q0.size();
        for (int i = 0; i < size; i++) {
            x.e eVar = (x.e) fVar.f14160q0.get(i);
            int[] iArr = eVar.f14149p0;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(eVar);
            }
        }
        fVar.f14162s0.f14384b = true;
    }

    @Override // s0.g
    public ClipDescription a() {
        return (ClipDescription) this.f7621w;
    }

    @Override // p0.c
    public boolean b(Object obj) {
        if (obj instanceof y6.b) {
            ((y6.b) obj).a().f14538a = true;
        }
        ((y6.c) this.f7621w).b(obj);
        return ((p0.e) this.f7622x).b(obj);
    }

    @Override // s0.g
    public Object c() {
        return null;
    }

    @Override // s0.g
    public Uri d() {
        return (Uri) this.f7620v;
    }

    @Override // q6.a
    public b0 f(b0 b0Var, i iVar) {
        Drawable drawable = (Drawable) b0Var.get();
        if (drawable instanceof BitmapDrawable) {
            return ((e6.i) this.f7621w).f(l6.d.e(((BitmapDrawable) drawable).getBitmap(), (f6.a) this.f7620v), iVar);
        }
        if (drawable instanceof p6.b) {
            return ((q6.d) this.f7622x).f(b0Var, iVar);
        }
        return null;
    }

    @Override // v1.g
    public h g() {
        return new x1.a((s) this.f7621w, (String) this.f7622x, (p2.c) this.f7620v);
    }

    @Override // s0.g
    public Uri h() {
        return (Uri) this.f7622x;
    }

    @Override // p0.c
    public Object i() {
        Object objI = ((p0.e) this.f7622x).i();
        if (objI == null) {
            objI = ((y6.a) this.f7620v).r();
            if (Log.isLoggable("FactoryPools", 2)) {
                Log.v("FactoryPools", "Created new " + objI.getClass());
            }
        }
        if (objI instanceof y6.b) {
            ((y6.b) objI).a().f14538a = false;
        }
        return objI;
    }

    public boolean k() {
        synchronized (this) {
            if (((AtomicBoolean) this.f7622x).get()) {
                return false;
            }
            ((AtomicInteger) this.f7621w).incrementAndGet();
            return true;
        }
    }

    @Override // ra.b
    public void l(String str, Bundle bundle) {
        CountDownLatch countDownLatch = (CountDownLatch) this.f7622x;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }

    public Bitmap n(BitmapFactory.Options options) {
        switch (this.f7619u) {
            case 3:
                return BitmapFactory.decodeStream(new x6.a(x6.b.c((ByteBuffer) this.f7620v)), null, options);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                v vVar = (v) ((com.bumptech.glide.load.data.i) this.f7620v).f2811v;
                vVar.reset();
                return BitmapFactory.decodeStream(vVar, null, options);
            default:
                return BitmapFactory.decodeFileDescriptor(((com.bumptech.glide.load.data.i) this.f7622x).e().getFileDescriptor(), null, options);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e6.i o() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.b.o():e6.i");
    }

    @Override // ra.a
    public void p(Bundle bundle) {
        synchronized (this.f7621w) {
            try {
                qa.c cVar = qa.c.f11167a;
                cVar.e("Logging event _ae to Firebase Analytics with params " + bundle);
                this.f7622x = new CountDownLatch(1);
                ((a1) this.f7620v).p(bundle);
                cVar.e("Awaiting app exception callback from Analytics...");
                try {
                    if (((CountDownLatch) this.f7622x).await(500, TimeUnit.MILLISECONDS)) {
                        cVar.e("App exception callback received from Analytics listener.");
                    } else {
                        cVar.f("Timeout exceeded while awaiting app exception callback from Analytics listener.", null);
                    }
                } catch (InterruptedException unused) {
                    Log.e("FirebaseCrashlytics", "Interrupted while awaiting app exception callback from Analytics listener.", null);
                }
                this.f7622x = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ColorStateList q(int i) {
        int resourceId;
        ColorStateList colorStateListC;
        TypedArray typedArray = (TypedArray) this.f7621w;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListC = f0.c.c((Context) this.f7620v, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListC;
    }

    public long r() {
        l lVar = (l) this.f7622x;
        if (lVar != null) {
            return lVar.f13653x;
        }
        return -1L;
    }

    public Drawable s(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f7621w;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : com.bumptech.glide.d.p((Context) this.f7620v, resourceId);
    }

    public Drawable t(int i) {
        int resourceId;
        Drawable drawableG;
        if (!((TypedArray) this.f7621w).hasValue(i) || (resourceId = ((TypedArray) this.f7621w).getResourceId(i, 0)) == 0) {
            return null;
        }
        t tVarA = t.a();
        Context context = (Context) this.f7620v;
        synchronized (tVarA) {
            drawableG = tVarA.f8534a.g(context, resourceId, true);
        }
        return drawableG;
    }

    public String toString() {
        switch (this.f7619u) {
            case 24:
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append((String) this.f7620v);
                sb2.append('{');
                p2.c cVar = (p2.c) ((p2.c) this.f7621w).f10131w;
                String str = "";
                while (cVar != null) {
                    Object obj = cVar.f10130v;
                    sb2.append(str);
                    if (obj == null || !obj.getClass().isArray()) {
                        sb2.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb2.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    cVar = (p2.c) cVar.f10131w;
                    str = ", ";
                }
                sb2.append('}');
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public Typeface u(int i, int i10, s0 s0Var) {
        int resourceId = ((TypedArray) this.f7621w).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.f7622x) == null) {
            this.f7622x = new TypedValue();
        }
        Context context = (Context) this.f7620v;
        TypedValue typedValue = (TypedValue) this.f7622x;
        ThreadLocal threadLocal = h0.k.f5599a;
        if (context.isRestricted()) {
            return null;
        }
        return h0.k.b(context, resourceId, typedValue, i10, s0Var, true, false);
    }

    public ImageHeaderParser$ImageType v() throws Throwable {
        switch (this.f7619u) {
            case 3:
                return t1.q((List) this.f7621w, x6.b.c((ByteBuffer) this.f7620v));
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                List list = (List) this.f7622x;
                v vVar = (v) ((com.bumptech.glide.load.data.i) this.f7620v).f2811v;
                vVar.reset();
                return t1.p(list, vVar, (f6.f) this.f7621w);
            default:
                List list2 = (List) this.f7621w;
                com.bumptech.glide.load.data.i iVar = (com.bumptech.glide.load.data.i) this.f7622x;
                f6.f fVar = (f6.f) this.f7620v;
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    c6.e eVar = (c6.e) list2.get(i);
                    v vVar2 = null;
                    try {
                        v vVar3 = new v(new FileInputStream(iVar.e().getFileDescriptor()), fVar);
                        try {
                            ImageHeaderParser$ImageType imageHeaderParser$ImageTypeD = eVar.d(vVar3);
                            vVar3.d();
                            iVar.e();
                            if (imageHeaderParser$ImageTypeD != ImageHeaderParser$ImageType.UNKNOWN) {
                                return imageHeaderParser$ImageTypeD;
                            }
                        } catch (Throwable th) {
                            th = th;
                            vVar2 = vVar3;
                            if (vVar2 != null) {
                                vVar2.d();
                            }
                            iVar.e();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x05fb  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x039a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0611 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x023b  */
    /* JADX WARN: Type inference failed for: r0v123 */
    /* JADX WARN: Type inference failed for: r0v124, types: [int] */
    /* JADX WARN: Type inference failed for: r0v200 */
    /* JADX WARN: Type inference failed for: r0v201 */
    /* JADX WARN: Type inference failed for: r0v202 */
    /* JADX WARN: Type inference failed for: r0v203 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean w() {
        /*
            Method dump skipped, instruction units count: 1680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.b.w():boolean");
    }

    public void x(String str, String str2) {
        ((HashMap) this.f7622x).put(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z(v1.h r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, o2.u0 r15) throws c3.d {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.b.z(v1.h, android.net.Uri, java.util.Map, long, long, o2.u0):void");
    }

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i) {
        this.f7619u = i;
        this.f7620v = obj;
        this.f7621w = obj2;
        this.f7622x = obj3;
    }

    public b(Set set, String str, String str2) {
        this.f7619u = 17;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        Map map = Collections.EMPTY_MAP;
        this.f7621w = str2;
        this.f7622x = l8.a.f8019a;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (!it.hasNext()) {
            this.f7620v = Collections.unmodifiableSet(hashSet);
            return;
        }
        throw l4.a.k(it);
    }

    public b(List list) {
        this.f7619u = 8;
        this.f7622x = list;
        this.f7620v = new ArrayList(list.size());
        this.f7621w = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            ((ArrayList) this.f7620v).add(new n((List) ((s5.f) list.get(i)).f11816b.f2454v));
            ((ArrayList) this.f7621w).add(((s5.f) list.get(i)).f11817c.D0());
        }
    }

    public b(LinearLayout linearLayout, TextView textView, ProgressBar progressBar, RecyclerView recyclerView) {
        this.f7619u = 1;
        this.f7620v = textView;
        this.f7621w = progressBar;
        this.f7622x = recyclerView;
    }

    public b(r4.s sVar) {
        this.f7619u = 15;
        this.f7620v = sVar;
        this.f7621w = new AtomicInteger(0);
        this.f7622x = new AtomicBoolean(false);
    }

    public b(String str, HashMap map) {
        this.f7619u = 23;
        this.f7620v = str;
        this.f7621w = map;
        this.f7622x = new HashMap();
    }

    public b(a1 a1Var) {
        this.f7619u = 13;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f7621w = new Object();
        this.f7620v = a1Var;
    }

    private final void H() {
    }

    private final void I() {
    }

    @Override // s0.g
    public void e() {
    }

    public b(FirebaseMessagingService firebaseMessagingService, ta.j jVar, ExecutorService executorService) {
        this.f7619u = 18;
        this.f7620v = executorService;
        this.f7621w = firebaseMessagingService;
        this.f7622x = jVar;
    }

    public b(r rVar) {
        this.f7619u = 7;
        this.f7620v = rVar;
    }

    public b(Context context, TypedArray typedArray) {
        this.f7619u = 6;
        this.f7620v = context;
        this.f7621w = typedArray;
    }

    public b(Runnable runnable) {
        this.f7619u = 11;
        this.f7621w = new CopyOnWriteArrayList();
        this.f7622x = new HashMap();
        this.f7620v = runnable;
    }

    public b(x.f fVar) {
        this.f7619u = 21;
        this.f7620v = new ArrayList();
        this.f7621w = new y.b();
        this.f7622x = fVar;
    }

    public b(s sVar) {
        this.f7619u = 20;
        this.f7621w = sVar;
        this.f7620v = new p2.c(21);
    }

    public b(String str) {
        this.f7619u = 24;
        p2.c cVar = new p2.c(26, false);
        this.f7621w = cVar;
        this.f7622x = cVar;
        this.f7620v = str;
    }

    public b(p0.e eVar, y6.a aVar, y6.c cVar) {
        this.f7619u = 22;
        this.f7622x = eVar;
        this.f7620v = aVar;
        this.f7621w = cVar;
    }

    public b(x6.j jVar, ArrayList arrayList, f6.f fVar) {
        this.f7619u = 4;
        x6.f.c(fVar, "Argument must not be null");
        this.f7621w = fVar;
        x6.f.c(arrayList, "Argument must not be null");
        this.f7622x = arrayList;
        this.f7620v = new com.bumptech.glide.load.data.i(jVar, fVar);
    }

    public b(ParcelFileDescriptor parcelFileDescriptor, ArrayList arrayList, f6.f fVar) {
        this.f7619u = 5;
        x6.f.c(fVar, "Argument must not be null");
        this.f7620v = fVar;
        x6.f.c(arrayList, "Argument must not be null");
        this.f7621w = arrayList;
        this.f7622x = new com.bumptech.glide.load.data.i(parcelFileDescriptor);
    }
}
