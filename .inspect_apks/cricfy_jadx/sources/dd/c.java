package dd;

import a9.l;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.emoji2.text.v;
import androidx.emoji2.text.w;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tonyodev.fetch2.database.DownloadDatabase;
import ge.i;
import hb.p;
import hb.r;
import hb.s;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import k2.u;
import ka.c0;
import kf.o;
import kf.x;
import vc.e1;
import vc.q0;
import vd.h;
import y1.a0;
import yc.j;
import yc.n;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements z7.b, x3.g, hb.c, xc.b {
    public Object A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3671v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f3672w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f3673x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f3674y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f3675z;

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i) {
        this.f3671v = i;
        this.f3672w = obj;
        this.f3673x = obj2;
        this.f3674y = obj3;
        this.f3675z = obj4;
        this.A = obj5;
    }

    public static c m(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        c cVar = new c(sharedPreferences, scheduledThreadPoolExecutor);
        synchronized (((ArrayDeque) cVar.f3675z)) {
            try {
                ((ArrayDeque) cVar.f3675z).clear();
                String string = ((SharedPreferences) cVar.f3672w).getString((String) cVar.f3673x, "");
                if (!TextUtils.isEmpty(string) && string.contains((String) cVar.f3674y)) {
                    String[] strArrSplit = string.split((String) cVar.f3674y, -1);
                    if (strArrSplit.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            ((ArrayDeque) cVar.f3675z).add(str);
                        }
                    }
                    return cVar;
                }
                return cVar;
            } finally {
            }
        }
    }

    @Override // x3.g
    public int a(long j4) {
        long[] jArr = (long[]) this.f3673x;
        int iA = a0.a(jArr, j4, false);
        if (iA < jArr.length) {
            return iA;
        }
        return -1;
    }

    @Override // hb.c
    public Object b(Class cls) {
        if (!((Set) this.f3672w).contains(r.a(cls))) {
            throw new l("Attempting to request an undeclared dependency " + cls + ".");
        }
        Object objB = ((hb.c) this.A).b(cls);
        if (!cls.equals(ec.b.class)) {
            return objB;
        }
        return new s();
    }

    @Override // hb.c
    public p c(r rVar) {
        if (((Set) this.f3674y).contains(rVar)) {
            return ((hb.c) this.A).c(rVar);
        }
        throw new l("Attempting to request an undeclared dependency Deferred<" + rVar + ">.");
    }

    @Override // hb.c
    public hc.b d(r rVar) {
        if (((Set) this.f3673x).contains(rVar)) {
            return ((hb.c) this.A).d(rVar);
        }
        throw new l("Attempting to request an undeclared dependency Provider<" + rVar + ">.");
    }

    @Override // x3.g
    public long e(int i) {
        return ((long[]) this.f3673x)[i];
    }

    @Override // hb.c
    public Object f(r rVar) {
        if (((Set) this.f3672w).contains(rVar)) {
            return ((hb.c) this.A).f(rVar);
        }
        throw new l("Attempting to request an undeclared dependency " + rVar + ".");
    }

    @Override // hb.c
    public hc.b g(Class cls) {
        return d(r.a(cls));
    }

    @Override // qd.a
    public Object get() {
        switch (this.f3671v) {
            case 1:
                return new c8.c((Executor) ((qd.a) this.f3672w).get(), (y7.d) ((qd.a) this.f3673x).get(), (v) ((v) this.f3674y).get(), (e8.d) ((qd.a) this.f3675z).get(), (f8.c) ((qd.a) this.A).get());
            case 15:
                return new q0((ab.g) ((ma.e) this.f3672w).f8417v, (ic.d) ((qd.a) this.f3673x).get(), (j) ((qd.a) this.f3674y).get(), (vc.l) ((xc.c) this.f3675z).get(), (h) ((qd.a) this.A).get());
            default:
                return new yc.c((e1) ((qd.a) this.f3672w).get(), (ic.d) ((qd.a) this.f3673x).get(), (vc.b) ((qd.a) this.f3674y).get(), (yc.d) ((qd.a) this.f3675z).get(), (n) ((xc.c) this.A).get());
        }
    }

    @Override // hb.c
    public Set h(r rVar) {
        if (((Set) this.f3675z).contains(rVar)) {
            return ((hb.c) this.A).h(rVar);
        }
        throw new l("Attempting to request an undeclared dependency Set<" + rVar + ">.");
    }

    @Override // x3.g
    public List i(long j4) {
        d4.c cVar = (d4.c) this.f3672w;
        Map map = (Map) this.f3674y;
        HashMap map2 = (HashMap) this.f3675z;
        HashMap map3 = (HashMap) this.A;
        ArrayList arrayList = new ArrayList();
        cVar.g(j4, cVar.f3348h, arrayList);
        TreeMap treeMap = new TreeMap();
        cVar.i(j4, false, cVar.f3348h, treeMap);
        cVar.h(j4, map, map2, cVar.f3348h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Pair pair = (Pair) obj;
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                d4.g gVar = (d4.g) map2.get(pair.first);
                gVar.getClass();
                arrayList2.add(new x1.b(null, null, null, bitmapDecodeByteArray, gVar.f3365c, 0, gVar.f3367e, gVar.f3364b, 0, Integer.MIN_VALUE, -3.4028235E38f, gVar.f, gVar.f3368g, false, -16777216, gVar.f3370j, 0.0f, 0));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            d4.g gVar2 = (d4.g) map2.get(entry.getKey());
            gVar2.getClass();
            x1.a aVar = (x1.a) entry.getValue();
            CharSequence charSequence = aVar.f14225a;
            charSequence.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            for (d4.a aVar2 : (d4.a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), d4.a.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar2), spannableStringBuilder.getSpanEnd(aVar2), (CharSequence) "");
            }
            for (int i10 = 0; i10 < spannableStringBuilder.length(); i10++) {
                if (spannableStringBuilder.charAt(i10) == ' ') {
                    int i11 = i10 + 1;
                    int i12 = i11;
                    while (i12 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i12) == ' ') {
                        i12++;
                    }
                    int i13 = i12 - i11;
                    if (i13 > 0) {
                        spannableStringBuilder.delete(i10, i13 + i10);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            for (int i14 = 0; i14 < spannableStringBuilder.length() - 1; i14++) {
                if (spannableStringBuilder.charAt(i14) == '\n') {
                    int i15 = i14 + 1;
                    if (spannableStringBuilder.charAt(i15) == ' ') {
                        spannableStringBuilder.delete(i15, i14 + 2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            for (int i16 = 0; i16 < spannableStringBuilder.length() - 1; i16++) {
                if (spannableStringBuilder.charAt(i16) == ' ') {
                    int i17 = i16 + 1;
                    if (spannableStringBuilder.charAt(i17) == '\n') {
                        spannableStringBuilder.delete(i16, i17);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            float f = gVar2.f3365c;
            int i18 = gVar2.f3366d;
            aVar.f14229e = f;
            aVar.f = i18;
            aVar.f14230g = gVar2.f3367e;
            aVar.f14231h = gVar2.f3364b;
            aVar.f14234l = gVar2.f;
            float f10 = gVar2.i;
            int i19 = gVar2.f3369h;
            aVar.f14233k = f10;
            aVar.f14232j = i19;
            aVar.f14238p = gVar2.f3370j;
            arrayList2.add(aVar.a());
        }
        return arrayList2;
    }

    @Override // x3.g
    public int j() {
        return ((long[]) this.f3673x).length;
    }

    public boolean k(String str) {
        boolean zAdd;
        if (TextUtils.isEmpty(str) || str.contains((String) this.f3674y)) {
            return false;
        }
        synchronized (((ArrayDeque) this.f3675z)) {
            zAdd = ((ArrayDeque) this.f3675z).add(str);
            if (zAdd) {
                ((ScheduledThreadPoolExecutor) this.A).execute(new w(27, this));
            }
        }
        return zAdd;
    }

    public void l(String str, String str2) {
        i.e(str, "name");
        i.e(str2, "value");
        ((o) this.f3674y).a(str, str2);
    }

    public p n(Class cls) {
        return c(r.a(cls));
    }

    public void o(String str, String str2) {
        i.e(str, "name");
        i.e(str2, "value");
        o oVar = (o) this.f3674y;
        oVar.getClass();
        n5.a.t(str);
        n5.a.u(str2, str);
        oVar.e(str);
        n5.a.f(oVar, str, str2);
    }

    public void p(String str, x xVar) {
        i.e(str, "method");
        if (str.length() <= 0) {
            throw new IllegalArgumentException("method.isEmpty() == true");
        }
        if (xVar == null) {
            if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("QUERY") || str.equals("REPORT")) {
                throw new IllegalArgumentException(l0.e.k("method ", str, " must have a request body.").toString());
            }
        } else if (!w1.d.r(str)) {
            throw new IllegalArgumentException(l0.e.k("method ", str, " must not have a request body.").toString());
        }
        this.f3673x = str;
        this.f3675z = xVar;
    }

    public String q() {
        String str;
        synchronized (((ArrayDeque) this.f3675z)) {
            str = (String) ((ArrayDeque) this.f3675z).peek();
        }
        return str;
    }

    public boolean r(Object obj) {
        boolean zRemove;
        synchronized (((ArrayDeque) this.f3675z)) {
            zRemove = ((ArrayDeque) this.f3675z).remove(obj);
            if (zRemove) {
                ((ScheduledThreadPoolExecutor) this.A).execute(new w(27, this));
            }
        }
        return zRemove;
    }

    public void s(u7.a aVar, u7.g gVar) {
        x7.p pVar = (x7.p) this.A;
        x7.i iVar = (x7.i) this.f3672w;
        String str = (String) this.f3673x;
        u7.e eVar = (u7.e) this.f3675z;
        if (eVar == null) {
            throw new NullPointerException("Null transformer");
        }
        u7.c cVar = (u7.c) this.f3674y;
        c8.d dVar = pVar.f14452c;
        x7.i iVarB = iVar.b(aVar.f12277b);
        u5.a aVar2 = new u5.a();
        aVar2.f = new HashMap();
        aVar2.f12216e = Long.valueOf(pVar.f14450a.l());
        aVar2.f12212a = Long.valueOf(pVar.f14451b.l());
        aVar2.f12213b = str;
        aVar2.f12215d = new x7.l(cVar, (byte[]) eVar.apply(aVar.f12276a));
        aVar2.f12214c = null;
        u7.b bVar = aVar.f12278c;
        if (bVar != null) {
            aVar2.f12217g = bVar.f12279a;
        }
        c8.c cVar2 = (c8.c) dVar;
        cVar2.f2119b.execute(new c8.a(cVar2, iVarB, gVar, aVar2.b(), 0));
    }

    public Set t(Class cls) {
        return h(r.a(cls));
    }

    public void u(String str) {
        i.e(str, "url");
        if (ne.o.Z(str, "ws:", true)) {
            String strSubstring = str.substring(3);
            i.d(strSubstring, "substring(...)");
            str = "http:".concat(strSubstring);
        } else if (ne.o.Z(str, "wss:", true)) {
            String strSubstring2 = str.substring(4);
            i.d(strSubstring2, "substring(...)");
            str = "https:".concat(strSubstring2);
        }
        i.e(str, "<this>");
        c0 c0Var = new c0(1);
        c0Var.e(null, str);
        this.f3672w = c0Var.b();
    }

    public /* synthetic */ c(boolean z10) {
        this.f3671v = 5;
    }

    public c(Drawable.Callback callback) {
        this.f3671v = 4;
        this.f3672w = new u();
        this.f3673x = new HashMap();
        this.f3674y = new HashMap();
        this.A = ".ttf";
        if (!(callback instanceof View)) {
            s6.c.b("LottieDrawable must be inside of a view for images to work.");
            this.f3675z = null;
        } else {
            this.f3675z = ((View) callback).getContext().getAssets();
        }
    }

    public c(hb.b bVar, hb.c cVar) {
        this.f3671v = 3;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        Set<hb.j> set = bVar.f5878c;
        Set set2 = bVar.f5881g;
        for (hb.j jVar : set) {
            int i = jVar.f5897c;
            int i10 = jVar.f5896b;
            boolean z10 = i == 0;
            r rVar = jVar.f5895a;
            if (z10) {
                if (i10 == 2) {
                    hashSet4.add(rVar);
                } else {
                    hashSet.add(rVar);
                }
            } else if (i == 2) {
                hashSet3.add(rVar);
            } else if (i10 == 2) {
                hashSet5.add(rVar);
            } else {
                hashSet2.add(rVar);
            }
        }
        if (!set2.isEmpty()) {
            hashSet.add(r.a(ec.b.class));
        }
        this.f3672w = Collections.unmodifiableSet(hashSet);
        this.f3673x = Collections.unmodifiableSet(hashSet2);
        this.f3674y = Collections.unmodifiableSet(hashSet3);
        this.f3675z = Collections.unmodifiableSet(hashSet4);
        Collections.unmodifiableSet(hashSet5);
        this.A = cVar;
    }

    public c(d4.c cVar, HashMap map, HashMap map2, HashMap map3) {
        this.f3671v = 2;
        this.f3672w = cVar;
        this.f3675z = map2;
        this.A = map3;
        this.f3674y = Collections.unmodifiableMap(map);
        TreeSet treeSet = new TreeSet();
        int i = 0;
        cVar.d(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        this.f3673x = jArr;
    }

    public c(SwipeRefreshLayout swipeRefreshLayout, LinearLayout linearLayout, TextView textView, TextView textView2, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout2) {
        this.f3671v = 12;
        this.f3672w = linearLayout;
        this.f3673x = textView;
        this.f3674y = textView2;
        this.f3675z = recyclerView;
        this.A = swipeRefreshLayout2;
    }

    public c(DownloadDatabase downloadDatabase) {
        this.f3671v = 0;
        this.f3674y = new fc.e(10);
        this.f3672w = downloadDatabase;
        this.f3673x = new a(this, downloadDatabase);
        this.f3675z = new b(downloadDatabase);
        this.A = new b(this, downloadDatabase);
        new a(downloadDatabase);
    }

    public c(ScrollView scrollView, LinearLayout linearLayout, TextInputLayout textInputLayout, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, TextInputEditText textInputEditText3, TextInputLayout textInputLayout4, TextInputEditText textInputEditText4) {
        this.f3671v = 11;
        this.f3672w = linearLayout;
        this.f3673x = textInputEditText;
        this.f3674y = textInputEditText2;
        this.f3675z = textInputEditText3;
        this.A = textInputEditText4;
    }

    public c(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f3671v = 8;
        this.f3675z = new ArrayDeque();
        this.f3672w = sharedPreferences;
        this.f3673x = "topic_operation_queue";
        this.f3674y = ",";
        this.A = scheduledThreadPoolExecutor;
    }

    public c(String str, LinkedHashMap linkedHashMap, String str2, Uri uri, String str3, md.g gVar) {
        this.f3671v = 7;
        i.e(str, "url");
        i.e(str2, "file");
        i.e(gVar, "extras");
        this.f3672w = str;
        this.f3673x = linkedHashMap;
        this.f3674y = str2;
        this.f3675z = str3;
        this.A = gVar;
    }

    public c() {
        this.f3671v = 5;
        this.A = lf.a.f7956a;
        this.f3673x = "GET";
        this.f3674y = new o(0);
    }

    public c(nf.d dVar) {
        this.f3671v = 10;
        i.e(dVar, "taskRunner");
        this.f3672w = dVar;
        this.f3675z = rf.n.f11097a;
        this.A = rf.c.f11054a;
    }
}
