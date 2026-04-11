package hd;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import c.d0;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f5928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f5929e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f5930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f5931h;

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        this.f5925a = obj;
        this.f5926b = obj2;
        this.f5927c = obj3;
        this.f5928d = obj4;
        this.f5929e = obj5;
        this.f = obj6;
        this.f5930g = obj7;
        this.f5931h = obj8;
    }

    public static e a(View view) {
        int i = q5.k.categories_fragment_container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) android.support.v4.media.session.b.l(view, i);
        if (fragmentContainerView != null) {
            i = q5.k.channels_fragment_container;
            FragmentContainerView fragmentContainerView2 = (FragmentContainerView) android.support.v4.media.session.b.l(view, i);
            if (fragmentContainerView2 != null) {
                i = q5.k.events_fragment_container;
                FragmentContainerView fragmentContainerView3 = (FragmentContainerView) android.support.v4.media.session.b.l(view, i);
                if (fragmentContainerView3 != null) {
                    i = q5.k.fav_fragment_container;
                    FragmentContainerView fragmentContainerView4 = (FragmentContainerView) android.support.v4.media.session.b.l(view, i);
                    if (fragmentContainerView4 != null) {
                        i = q5.k.noti_fragment_container;
                        FragmentContainerView fragmentContainerView5 = (FragmentContainerView) android.support.v4.media.session.b.l(view, i);
                        if (fragmentContainerView5 != null) {
                            i = q5.k.playlists_fragment_container;
                            FragmentContainerView fragmentContainerView6 = (FragmentContainerView) android.support.v4.media.session.b.l(view, i);
                            if (fragmentContainerView6 != null) {
                                i = q5.k.sp_channels_fragment_container;
                                FragmentContainerView fragmentContainerView7 = (FragmentContainerView) android.support.v4.media.session.b.l(view, i);
                                if (fragmentContainerView7 != null) {
                                    i = q5.k.sports_fragment_container;
                                    FragmentContainerView fragmentContainerView8 = (FragmentContainerView) android.support.v4.media.session.b.l(view, i);
                                    if (fragmentContainerView8 != null) {
                                        return new e(fragmentContainerView, fragmentContainerView2, fragmentContainerView3, fragmentContainerView4, fragmentContainerView5, fragmentContainerView6, fragmentContainerView7, fragmentContainerView8);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public void b() {
        synchronized (this.f) {
        }
    }

    public void c() {
        md.j jVar = (md.j) this.f5925a;
        b bVar = (b) this.f5931h;
        ge.i.e(bVar, "runnable");
        synchronized (jVar.f8441a) {
            if (!jVar.f8442b) {
                jVar.f8444d.postDelayed(bVar, 300000L);
            }
        }
    }

    public e(cd.c cVar, md.j jVar, Handler handler, a aVar, d5.a aVar2, d8.j jVar2, dd.g gVar) {
        ge.i.e(handler, "uiHandler");
        ge.i.e(aVar, "fetchHandler");
        ge.i.e(aVar2, "logger");
        this.f5925a = jVar;
        this.f5926b = handler;
        this.f5927c = aVar;
        this.f5928d = aVar2;
        this.f5929e = jVar2;
        this.f = new Object();
        this.f5930g = new LinkedHashSet();
        b bVar = new b(this);
        this.f5931h = bVar;
        jVar.d(new d0(4, this));
        synchronized (jVar.f8441a) {
            if (!jVar.f8442b) {
                jVar.f8444d.postDelayed(bVar, 300000L);
            }
        }
    }

    public e(ConstraintLayout constraintLayout, LinearLayout linearLayout, ProgressBar progressBar, Button button, TextView textView, TextView textView2, TextView textView3, Button button2, Button button3) {
        this.f5925a = linearLayout;
        this.f5926b = progressBar;
        this.f5927c = button;
        this.f5928d = textView;
        this.f5929e = textView2;
        this.f = textView3;
        this.f5930g = button2;
        this.f5931h = button3;
    }
}
