package c7;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f2546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f2547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f2548e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f2549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f2550h;
    public Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f2551j;

    public /* synthetic */ h(View view, View view2, View view3, View view4, View view5, View view6, View view7, TextView textView, View view8, View view9) {
        this.f2544a = view;
        this.f2545b = view2;
        this.f2546c = view3;
        this.f2547d = view4;
        this.f2548e = view5;
        this.f = view6;
        this.f2549g = view7;
        this.f2550h = textView;
        this.i = view8;
        this.f2551j = view9;
    }

    public static h b(View view) {
        int i = gc.j.categories_fragment_container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) z7.a.k(view, i);
        if (fragmentContainerView != null) {
            i = gc.j.channels_fragment_container;
            FragmentContainerView fragmentContainerView2 = (FragmentContainerView) z7.a.k(view, i);
            if (fragmentContainerView2 != null) {
                i = gc.j.error_lay;
                LinearLayout linearLayout = (LinearLayout) z7.a.k(view, i);
                if (linearLayout != null) {
                    i = gc.j.events_fragment_container;
                    FragmentContainerView fragmentContainerView3 = (FragmentContainerView) z7.a.k(view, i);
                    if (fragmentContainerView3 != null) {
                        i = gc.j.fav_fragment_container;
                        FragmentContainerView fragmentContainerView4 = (FragmentContainerView) z7.a.k(view, i);
                        if (fragmentContainerView4 != null) {
                            i = gc.j.ns_fragment_container;
                            FragmentContainerView fragmentContainerView5 = (FragmentContainerView) z7.a.k(view, i);
                            if (fragmentContainerView5 != null) {
                                i = gc.j.playlists_fragment_container;
                                FragmentContainerView fragmentContainerView6 = (FragmentContainerView) z7.a.k(view, i);
                                if (fragmentContainerView6 != null) {
                                    i = gc.j.refresh_lay_btn;
                                    Button button = (Button) z7.a.k(view, i);
                                    if (button != null) {
                                        i = gc.j.sp_channels_fragment_container;
                                        FragmentContainerView fragmentContainerView7 = (FragmentContainerView) z7.a.k(view, i);
                                        if (fragmentContainerView7 != null) {
                                            i = gc.j.sports_fragment_container;
                                            FragmentContainerView fragmentContainerView8 = (FragmentContainerView) z7.a.k(view, i);
                                            if (fragmentContainerView8 != null) {
                                                return new h(fragmentContainerView, fragmentContainerView2, linearLayout, fragmentContainerView3, fragmentContainerView4, fragmentContainerView5, fragmentContainerView6, button, fragmentContainerView7, fragmentContainerView8);
                                            }
                                        }
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

    public void a(String str, String str2) {
        HashMap map = (HashMap) this.f2550h;
        if (map == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put(str, str2);
    }

    public i c() {
        String strM = ((String) this.f2544a) == null ? " transportName" : "";
        if (((n) this.f2548e) == null) {
            strM = strM.concat(" encodedPayload");
        }
        if (((Long) this.f) == null) {
            strM = e6.j.m(strM, " eventMillis");
        }
        if (((Long) this.f2549g) == null) {
            strM = e6.j.m(strM, " uptimeMillis");
        }
        if (((HashMap) this.f2550h) == null) {
            strM = e6.j.m(strM, " autoMetadata");
        }
        if (strM.isEmpty()) {
            return new i((String) this.f2544a, (Integer) this.f2546c, (n) this.f2548e, ((Long) this.f).longValue(), ((Long) this.f2549g).longValue(), (HashMap) this.f2550h, (Integer) this.f2547d, (String) this.f2545b, (byte[]) this.i, (byte[]) this.f2551j);
        }
        throw new IllegalStateException("Missing required properties:".concat(strM));
    }
}
