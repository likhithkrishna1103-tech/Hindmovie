package s5;

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
import app.cricfy.tv.app.ProApplication;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.internal.measurement.j4;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import v4.x0;
import v4.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h.j f11497e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11499h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f11500j;
    public ArrayList f = new ArrayList();
    public int i = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f11501k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f11502l = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProApplication f11496d = ProApplication.K;

    public i(h.j jVar, List list, String str, String str2) {
        this.f11497e = jVar;
        this.f11498g = str;
        this.f11499h = str2;
        this.f11500j = com.bumptech.glide.d.t(jVar).getBoolean("is_tv", false);
        k(list);
    }

    public static void h(i iVar, String str, ImageView imageView) {
        h.j jVar = iVar.f11497e;
        s7.f.c(jVar, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        ((com.bumptech.glide.n) com.bumptech.glide.b.a(jVar).f2197z.c(jVar).q(str).o(q5.j.icon)).B(imageView);
    }

    @Override // v4.z
    public final int a() {
        return this.f.size();
    }

    @Override // v4.z
    public final long b(int i) {
        return i;
    }

    @Override // v4.z
    public final int c(int i) {
        return ((y5.e) this.f.get(i)).f14923a.equals("adpro*") ? 2 : 1;
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
    /* JADX WARN: Type inference failed for: r15v25, types: [com.bumptech.glide.n, o7.a] */
    /* JADX WARN: Type inference failed for: r15v56, types: [com.bumptech.glide.n, o7.a] */
    @Override // v4.z
    public final void e(x0 x0Var, int i) {
        y5.e eVar = (y5.e) this.f.get(i);
        if (x0Var instanceof g) {
            g gVar = (g) x0Var;
            if (gVar.f11489x.f11498g.contains("http://") || gVar.f11489x.f11498g.contains("https://")) {
                i iVar = gVar.f11489x;
                h.j jVar = iVar.f11497e;
                ?? D = com.bumptech.glide.b.d(jVar.getApplicationContext()).n().E(iVar.f11498g).D(new z5.j(new kb.d(13, gVar), jVar));
                o7.e eVar2 = new o7.e();
                D.C(eVar2, eVar2, D, s7.f.f11597b);
                gVar.f11487v.setOnClickListener(new com.google.android.material.datepicker.n(10, gVar));
                return;
            }
            try {
                if (Base64.decode(gVar.f11489x.f11498g, 0) != null) {
                    String str = new String(Base64.decode(gVar.f11489x.f11498g, 0));
                    if (!str.contains("<script") && !str.contains("*ad")) {
                        if (!str.contains("http://") && !str.contains("https://")) {
                            gVar.f11486u.setVisibility(8);
                            return;
                        }
                        i iVar2 = gVar.f11489x;
                        h.j jVar2 = iVar2.f11497e;
                        ?? D2 = com.bumptech.glide.b.d(jVar2.getApplicationContext()).n().E(iVar2.f11498g).D(new z5.j(new kb.d(13, gVar), jVar2));
                        o7.e eVar3 = new o7.e();
                        D2.C(eVar3, eVar3, D2, s7.f.f11597b);
                        gVar.f11487v.setOnClickListener(new com.google.android.material.datepicker.n(10, gVar));
                        return;
                    }
                    try {
                        String str2 = "http://localhost:9867/";
                        if (str.contains("*ad")) {
                            str2 = str.split("\\*")[0];
                        } else if (z5.l.f15222g == null) {
                            synchronized (z5.l.class) {
                                try {
                                    if (z5.l.f15222g == null) {
                                        z5.l.f15222g = new z5.l(str);
                                    } else {
                                        z5.l.f15222g.f = str;
                                        z5.l lVar = z5.l.f15222g;
                                        lVar.f15223e = "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Ad</title>\n    <style>\n        body {\n            display: flex;\n            justify-content: center;\n            align-items: center;\n            height: 100vh;\n            margin: 0;\n            background: transparent;\n        }\n    </style>\n</head>\n<body>\n" + lVar.f + "</body>\n</html>";
                                    }
                                } finally {
                                }
                            }
                        }
                        gVar.f11487v.setVisibility(8);
                        gVar.f11488w.setBackgroundColor(0);
                        gVar.f11488w.setWebViewClient(new f(gVar));
                        gVar.f11488w.setWebChromeClient(new WebChromeClient());
                        WebView.setWebContentsDebuggingEnabled(true);
                        gVar.f11488w.getSettings().setJavaScriptEnabled(true);
                        gVar.f11488w.getSettings().setDomStorageEnabled(true);
                        gVar.f11488w.getSettings().setMixedContentMode(0);
                        gVar.f11488w.getSettings().setUserAgentString("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2049.0 Safari/537.36");
                        gVar.f11488w.loadUrl(str2);
                        gVar.f11488w.setVisibility(0);
                        gVar.f11486u.setVisibility(0);
                        return;
                    } catch (IOException e9) {
                        Log.e("Error", "", e9);
                        Toast.makeText(gVar.f11489x.f11497e, e9.getMessage(), 0).show();
                        return;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            gVar.f11486u.setVisibility(8);
            return;
        }
        if (x0Var instanceof h) {
            h hVar = (h) x0Var;
            ?? Start = hVar.F;
            i iVar3 = hVar.H;
            hVar.G = i;
            TextView textView = hVar.C;
            textView.setText(eVar.f14923a + " || " + eVar.f14924b);
            textView.setSelected(true);
            TextView textView2 = hVar.f11494y;
            textView2.setText(eVar.f14926d);
            TextView textView3 = hVar.f11495z;
            textView3.setText(eVar.f14927e);
            textView2.setSelected(true);
            textView3.setSelected(true);
            hVar.D.setVisibility(eVar.f14935o == 1 ? 0 : 8);
            if (eVar.f14936p) {
                hVar.q(eVar);
                Start.setText("Ended");
            } else if (j4.u(eVar.f14930j, eVar.i)) {
                hVar.A.setVisibility(8);
                hVar.B.setVisibility(8);
                LottieAnimationView lottieAnimationView = hVar.E;
                lottieAnimationView.setVisibility(0);
                HashSet hashSet = lottieAnimationView.I;
                g6.g gVar2 = g6.g.A;
                hashSet.add(gVar2);
                lottieAnimationView.C.l();
                try {
                    ArrayList arrayList = iVar3.f11501k;
                    long jP = com.bumptech.glide.f.p(eVar.f14930j, eVar.i);
                    hVar.A.setVisibility(8);
                    hVar.B.setVisibility(8);
                    LottieAnimationView lottieAnimationView2 = hVar.E;
                    lottieAnimationView2.setVisibility(0);
                    lottieAnimationView2.I.add(gVar2);
                    lottieAnimationView2.C.l();
                    arrayList.add(new e6.a(hVar, jP).start());
                } catch (ParseException unused2) {
                    Start.setText("");
                }
            } else {
                ArrayList arrayList2 = iVar3.f11502l;
                try {
                    long jP2 = com.bumptech.glide.f.p(eVar.f14930j, eVar.i);
                    long jCurrentTimeMillis = jP2 - System.currentTimeMillis();
                    if (jCurrentTimeMillis <= 0) {
                        hVar.A.setVisibility(8);
                        hVar.B.setVisibility(8);
                        LottieAnimationView lottieAnimationView3 = hVar.E;
                        lottieAnimationView3.setVisibility(0);
                        lottieAnimationView3.I.add(g6.g.A);
                        lottieAnimationView3.C.l();
                        Start = new e6.a(hVar, jP2).start();
                    } else if (jCurrentTimeMillis >= 3600000) {
                        com.bumptech.glide.f.L(hVar, jCurrentTimeMillis);
                        Start = new e6.a(jCurrentTimeMillis, hVar, jP2, 0).start();
                    } else {
                        Start = new e6.a(jP2 - System.currentTimeMillis(), hVar, jP2, 1).start();
                    }
                } catch (ParseException e10) {
                    e10.printStackTrace();
                    Start.setText("Date Error");
                    Start = 0;
                }
                arrayList2.add(Start);
                hVar.q(eVar);
            }
            h(iVar3, eVar.f14925c, hVar.f11491v);
            h(iVar3, eVar.f, hVar.f11492w);
            h(iVar3, eVar.f14928g, hVar.f11493x);
            hVar.f11490u.setOnClickListener(new b(1, hVar, eVar));
        }
    }

    @Override // v4.z
    public final x0 f(ViewGroup viewGroup, int i) {
        return i == 2 ? new g(this, LayoutInflater.from(viewGroup.getContext()).inflate(q5.l.item_banner, viewGroup, false)) : new h(this, LayoutInflater.from(viewGroup.getContext()).inflate(q5.l.item_event, viewGroup, false));
    }

    public final boolean i() {
        String str;
        String str2 = this.f11498g;
        if (str2 == null) {
            return false;
        }
        if (str2.contains("http://") || this.f11498g.contains("https://")) {
            return true;
        }
        try {
            str = new String(Base64.decode(this.f11498g, 0));
        } catch (IllegalArgumentException unused) {
        }
        if (!str.contains("<script") && !str.contains("*ad") && !str.contains("http://")) {
            if (!str.contains("https://")) {
                return false;
            }
        }
        return true;
    }

    public final void j(String str, String str2, List list) {
        this.f11498g = str;
        this.f11499h = str2;
        this.i = -1;
        ArrayList arrayList = this.f11501k;
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
        ArrayList arrayList2 = this.f11502l;
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
        k(list);
        d();
    }

    public final void k(List list) {
        this.f.clear();
        if (list.isEmpty()) {
            return;
        }
        if (!i()) {
            this.f = new ArrayList(list);
            return;
        }
        y5.e eVar = new y5.e();
        eVar.f14923a = "adpro*";
        this.i = this.f.size();
        this.f.add(eVar);
    }
}
