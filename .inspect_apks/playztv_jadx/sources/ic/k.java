package ic;

import a2.f0;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.playz.tv.app.ProApplication;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import q4.x0;
import q4.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h.j f6522e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6524h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f6525j;
    public ArrayList f = new ArrayList();
    public int i = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f6526k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f6527l = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProApplication f6521d = ProApplication.I;

    public k(h.j jVar, List list, String str, String str2) {
        this.f6522e = jVar;
        this.f6523g = str;
        this.f6524h = str2;
        this.f6525j = uc.b.f(jVar).getBoolean("is_tv", false);
        j(list);
    }

    public static void g(k kVar, String str, ImageView imageView) {
        h.j jVar = kVar.f6522e;
        x6.f.c(jVar, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        ((com.bumptech.glide.k) com.bumptech.glide.b.a(jVar).f2764y.c(jVar).r(str).o(gc.i.icon)).D(imageView);
    }

    @Override // q4.z
    public final int a() {
        return this.f.size();
    }

    @Override // q4.z
    public final long b(int i) {
        return i;
    }

    @Override // q4.z
    public final int c(int i) {
        return ((oc.e) this.f.get(i)).f9526a.equals("adpro*") ? 2 : 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v2, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r15v24, types: [com.bumptech.glide.k, t6.a] */
    /* JADX WARN: Type inference failed for: r15v55, types: [com.bumptech.glide.k, t6.a] */
    @Override // q4.z
    public final void d(x0 x0Var, int i) {
        oc.e eVar = (oc.e) this.f.get(i);
        if (x0Var instanceof i) {
            i iVar = (i) x0Var;
            if (iVar.f6514x.f6523g.contains("http://") || iVar.f6514x.f6523g.contains("https://")) {
                k kVar = iVar.f6514x;
                h.j jVar = kVar.f6522e;
                String str = kVar.f6523g;
                f0 f0Var = new f0(26, iVar);
                Context applicationContext = jVar.getApplicationContext();
                x6.f.c(applicationContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
                ?? F = com.bumptech.glide.b.a(applicationContext).f2764y.b(applicationContext).n().I(str).F(new pc.j(f0Var, jVar));
                t6.e eVar2 = new t6.e();
                F.E(eVar2, eVar2, F, x6.f.f14281b);
                iVar.f6512v.setOnClickListener(new com.google.android.material.datepicker.n(7, iVar));
                return;
            }
            try {
                if (Base64.decode(iVar.f6514x.f6523g, 0) != null) {
                    String str2 = new String(Base64.decode(iVar.f6514x.f6523g, 0));
                    if (!str2.contains("<script") && !str2.contains("*ad")) {
                        if (!str2.contains("http://") && !str2.contains("https://")) {
                            iVar.f6511u.setVisibility(8);
                            return;
                        }
                        k kVar2 = iVar.f6514x;
                        h.j jVar2 = kVar2.f6522e;
                        String str3 = kVar2.f6523g;
                        f0 f0Var2 = new f0(26, iVar);
                        Context applicationContext2 = jVar2.getApplicationContext();
                        x6.f.c(applicationContext2, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
                        ?? F2 = com.bumptech.glide.b.a(applicationContext2).f2764y.b(applicationContext2).n().I(str3).F(new pc.j(f0Var2, jVar2));
                        t6.e eVar3 = new t6.e();
                        F2.E(eVar3, eVar3, F2, x6.f.f14281b);
                        iVar.f6512v.setOnClickListener(new com.google.android.material.datepicker.n(7, iVar));
                        return;
                    }
                    try {
                        String str4 = "http://localhost:9867/";
                        if (str2.contains("*ad")) {
                            str4 = str2.split("\\*")[0];
                        } else if (pc.m.f10334g == null) {
                            synchronized (pc.m.class) {
                                try {
                                    if (pc.m.f10334g == null) {
                                        pc.m.f10334g = new pc.m(str2);
                                    } else {
                                        pc.m.f10334g.f = str2;
                                        pc.m mVar = pc.m.f10334g;
                                        mVar.f10335e = "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Ad</title>\n    <style>\n        body {\n            display: flex;\n            justify-content: center;\n            align-items: center;\n            height: 100vh;\n            margin: 0;\n            background: transparent;\n        }\n    </style>\n</head>\n<body>\n" + mVar.f + "</body>\n</html>";
                                    }
                                } finally {
                                }
                            }
                        }
                        iVar.f6512v.setVisibility(8);
                        iVar.f6513w.setBackgroundColor(0);
                        iVar.f6513w.setWebViewClient(new h(iVar));
                        iVar.f6513w.setWebChromeClient(new WebChromeClient());
                        WebView.setWebContentsDebuggingEnabled(true);
                        iVar.f6513w.getSettings().setJavaScriptEnabled(true);
                        iVar.f6513w.getSettings().setDomStorageEnabled(true);
                        iVar.f6513w.getSettings().setMixedContentMode(0);
                        iVar.f6513w.getSettings().setUserAgentString("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2049.0 Safari/537.36");
                        iVar.f6513w.loadUrl(str4);
                        iVar.f6513w.setVisibility(0);
                        iVar.f6511u.setVisibility(0);
                        return;
                    } catch (IOException e10) {
                        Log.e("Error", "", e10);
                        Toast.makeText(iVar.f6514x.f6522e, e10.getMessage(), 0).show();
                        return;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            iVar.f6511u.setVisibility(8);
            return;
        }
        if (x0Var instanceof j) {
            j jVar3 = (j) x0Var;
            ?? Start = jVar3.E;
            k kVar3 = jVar3.G;
            jVar3.F = i;
            TextView textView = jVar3.C;
            textView.setText(eVar.f9526a + " || " + eVar.f9527b);
            textView.setSelected(true);
            TextView textView2 = jVar3.f6519y;
            textView2.setText(eVar.f9529d);
            TextView textView3 = jVar3.f6520z;
            textView3.setText(eVar.f9530e);
            textView2.setSelected(true);
            textView3.setSelected(true);
            if (eVar.f9539p) {
                jVar3.q(eVar);
                Start.setText("Ended");
            } else if (uc.b.l(eVar.f9533j, eVar.i)) {
                jVar3.A.setVisibility(8);
                jVar3.B.setVisibility(8);
                LottieAnimationView lottieAnimationView = jVar3.D;
                lottieAnimationView.setVisibility(0);
                HashSet hashSet = lottieAnimationView.H;
                l5.h hVar = l5.h.f7854z;
                hashSet.add(hVar);
                lottieAnimationView.B.j();
                try {
                    ArrayList arrayList = kVar3.f6526k;
                    long jB = uc.b.b(eVar.f9533j, eVar.i);
                    jVar3.A.setVisibility(8);
                    jVar3.B.setVisibility(8);
                    LottieAnimationView lottieAnimationView2 = jVar3.D;
                    lottieAnimationView2.setVisibility(0);
                    lottieAnimationView2.H.add(hVar);
                    lottieAnimationView2.B.j();
                    arrayList.add(new uc.a(jVar3, jB).start());
                } catch (ParseException unused2) {
                    Start.setText("");
                }
            } else {
                ArrayList arrayList2 = kVar3.f6527l;
                try {
                    long jB2 = uc.b.b(eVar.f9533j, eVar.i);
                    long jCurrentTimeMillis = jB2 - System.currentTimeMillis();
                    if (jCurrentTimeMillis <= 0) {
                        jVar3.A.setVisibility(8);
                        jVar3.B.setVisibility(8);
                        LottieAnimationView lottieAnimationView3 = jVar3.D;
                        lottieAnimationView3.setVisibility(0);
                        lottieAnimationView3.H.add(l5.h.f7854z);
                        lottieAnimationView3.B.j();
                        Start = new uc.a(jVar3, jB2).start();
                    } else if (jCurrentTimeMillis >= 3600000) {
                        uc.b.x(jVar3, jCurrentTimeMillis);
                        Start = new uc.a(jCurrentTimeMillis, jVar3, jB2, 0).start();
                    } else {
                        Start = new uc.a(jB2 - System.currentTimeMillis(), jVar3, jB2, 1).start();
                    }
                } catch (ParseException e11) {
                    e11.printStackTrace();
                    Start.setText("Date Error");
                    Start = 0;
                }
                arrayList2.add(Start);
                jVar3.q(eVar);
            }
            g(kVar3, eVar.f9528c, jVar3.f6516v);
            g(kVar3, eVar.f, jVar3.f6517w);
            g(kVar3, eVar.f9531g, jVar3.f6518x);
            jVar3.f6515u.setOnClickListener(new d(jVar3, 1, eVar));
        }
    }

    @Override // q4.z
    public final x0 e(ViewGroup viewGroup, int i) {
        return i == 2 ? new i(this, LayoutInflater.from(viewGroup.getContext()).inflate(gc.k.item_banner, viewGroup, false)) : new j(this, LayoutInflater.from(viewGroup.getContext()).inflate(gc.k.item_event, viewGroup, false));
    }

    public final boolean h() {
        String str;
        String str2 = this.f6523g;
        if (str2 == null) {
            return false;
        }
        if (str2.contains("http://") || this.f6523g.contains("https://")) {
            return true;
        }
        try {
            str = new String(Base64.decode(this.f6523g, 0));
        } catch (IllegalArgumentException unused) {
        }
        if (!str.contains("<script") && !str.contains("*ad") && !str.contains("http://")) {
            if (!str.contains("https://")) {
                return false;
            }
        }
        return true;
    }

    public final void i(String str, String str2, List list) {
        this.f6523g = str;
        this.f6524h = str2;
        this.i = -1;
        ArrayList arrayList = this.f6526k;
        int size = arrayList.size();
        int i = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            CountDownTimer countDownTimer = (CountDownTimer) obj;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
        ArrayList arrayList2 = this.f6527l;
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj2 = arrayList2.get(i);
            i++;
            CountDownTimer countDownTimer2 = (CountDownTimer) obj2;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
            }
        }
        arrayList.clear();
        arrayList2.clear();
        j(list);
        this.f10982a.b();
    }

    public final void j(List list) {
        this.f.clear();
        if (list.isEmpty()) {
            return;
        }
        if (!h()) {
            this.f = new ArrayList(list);
            return;
        }
        oc.e eVar = new oc.e();
        eVar.f9526a = "adpro*";
        boolean z2 = false;
        for (int i = 0; i < list.size(); i++) {
            this.f.add((oc.e) list.get(i));
            if (i == 2) {
                this.i = 3;
                this.f.add(eVar);
                z2 = true;
            }
        }
        if (z2) {
            return;
        }
        this.i = this.f.size();
        this.f.add(eVar);
    }
}
