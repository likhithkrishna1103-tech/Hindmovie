package kc;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.ui.DefaultTimeBar;
import gc.j;
import i4.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f7650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageButton f7651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageButton f7652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageButton f7653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageButton f7654e;
    public final ImageButton f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageButton f7655g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f7656h;
    public final View i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageButton f7657j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageButton f7658k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageButton f7659l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageButton f7660m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageButton f7661n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinearLayout f7662o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageButton f7663p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ImageButton f7664q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ConstraintLayout f7665r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ImageButton f7666s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final FrameLayout f7667t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final FrameLayout f7668u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ImageButton f7669v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final LinearLayout f7670w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final TextView f7671x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final TextView f7672y;

    public e(LinearLayout linearLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, LinearLayout linearLayout2, View view, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, LinearLayout linearLayout3, ImageButton imageButton12, ImageButton imageButton13, ConstraintLayout constraintLayout, ImageButton imageButton14, FrameLayout frameLayout, FrameLayout frameLayout2, ImageButton imageButton15, LinearLayout linearLayout4, TextView textView, TextView textView2) {
        this.f7650a = linearLayout;
        this.f7651b = imageButton;
        this.f7652c = imageButton2;
        this.f7653d = imageButton3;
        this.f7654e = imageButton4;
        this.f = imageButton5;
        this.f7655g = imageButton6;
        this.f7656h = linearLayout2;
        this.i = view;
        this.f7657j = imageButton7;
        this.f7658k = imageButton8;
        this.f7659l = imageButton9;
        this.f7660m = imageButton10;
        this.f7661n = imageButton11;
        this.f7662o = linearLayout3;
        this.f7663p = imageButton12;
        this.f7664q = imageButton13;
        this.f7665r = constraintLayout;
        this.f7666s = imageButton14;
        this.f7667t = frameLayout;
        this.f7668u = frameLayout2;
        this.f7669v = imageButton15;
        this.f7670w = linearLayout4;
        this.f7671x = textView;
        this.f7672y = textView2;
    }

    public static e a(View view) {
        View viewK;
        int i = j.bottom_controller;
        LinearLayout linearLayout = (LinearLayout) z7.a.k(view, i);
        if (linearLayout != null) {
            i = j.btn_back;
            ImageButton imageButton = (ImageButton) z7.a.k(view, i);
            if (imageButton != null) {
                i = j.btn_lock_unlock;
                ImageButton imageButton2 = (ImageButton) z7.a.k(view, i);
                if (imageButton2 != null) {
                    i = j.btn_mute;
                    ImageButton imageButton3 = (ImageButton) z7.a.k(view, i);
                    if (imageButton3 != null) {
                        i = j.btn_pip;
                        ImageButton imageButton4 = (ImageButton) z7.a.k(view, i);
                        if (imageButton4 != null) {
                            i = j.btn_settings;
                            ImageButton imageButton5 = (ImageButton) z7.a.k(view, i);
                            if (imageButton5 != null) {
                                i = j.close_btn;
                                ImageButton imageButton6 = (ImageButton) z7.a.k(view, i);
                                if (imageButton6 != null) {
                                    i = j.exo_center_ly;
                                    LinearLayout linearLayout2 = (LinearLayout) z7.a.k(view, i);
                                    if (linearLayout2 != null && (viewK = z7.a.k(view, (i = j.exo_controls_background))) != null) {
                                        i = h0.exo_duration;
                                        if (((TextView) z7.a.k(view, i)) != null) {
                                            i = h0.exo_ffwd;
                                            if (((ImageButton) z7.a.k(view, i)) != null) {
                                                i = j.exo_fullscreen_btn;
                                                ImageButton imageButton7 = (ImageButton) z7.a.k(view, i);
                                                if (imageButton7 != null) {
                                                    i = j.exo_lock;
                                                    ImageButton imageButton8 = (ImageButton) z7.a.k(view, i);
                                                    if (imageButton8 != null) {
                                                        i = j.exo_pause;
                                                        ImageButton imageButton9 = (ImageButton) z7.a.k(view, i);
                                                        if (imageButton9 != null) {
                                                            i = j.exo_play;
                                                            ImageButton imageButton10 = (ImageButton) z7.a.k(view, i);
                                                            if (imageButton10 != null) {
                                                                i = j.exo_play_pause;
                                                                ImageButton imageButton11 = (ImageButton) z7.a.k(view, i);
                                                                if (imageButton11 != null) {
                                                                    i = h0.exo_position;
                                                                    if (((TextView) z7.a.k(view, i)) != null) {
                                                                        i = h0.exo_progress;
                                                                        if (((DefaultTimeBar) z7.a.k(view, i)) != null) {
                                                                            i = h0.exo_rew;
                                                                            if (((ImageButton) z7.a.k(view, i)) != null) {
                                                                                i = j.exo_top_bar;
                                                                                LinearLayout linearLayout3 = (LinearLayout) z7.a.k(view, i);
                                                                                if (linearLayout3 != null) {
                                                                                    i = j.exo_unlock;
                                                                                    ImageButton imageButton12 = (ImageButton) z7.a.k(view, i);
                                                                                    if (imageButton12 != null) {
                                                                                        i = j.exo_volume;
                                                                                        ImageButton imageButton13 = (ImageButton) z7.a.k(view, i);
                                                                                        if (imageButton13 != null) {
                                                                                            i = j.extra_controls;
                                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) z7.a.k(view, i);
                                                                                            if (constraintLayout != null) {
                                                                                                i = j.fullscreen;
                                                                                                ImageButton imageButton14 = (ImageButton) z7.a.k(view, i);
                                                                                                if (imageButton14 != null) {
                                                                                                    i = j.links_container;
                                                                                                    FrameLayout frameLayout = (FrameLayout) z7.a.k(view, i);
                                                                                                    if (frameLayout != null) {
                                                                                                        i = j.main_controls;
                                                                                                        FrameLayout frameLayout2 = (FrameLayout) z7.a.k(view, i);
                                                                                                        if (frameLayout2 != null) {
                                                                                                            i = j.resize_mode;
                                                                                                            ImageButton imageButton15 = (ImageButton) z7.a.k(view, i);
                                                                                                            if (imageButton15 != null) {
                                                                                                                i = j.timer_bar_ly;
                                                                                                                LinearLayout linearLayout4 = (LinearLayout) z7.a.k(view, i);
                                                                                                                if (linearLayout4 != null) {
                                                                                                                    i = j.title;
                                                                                                                    TextView textView = (TextView) z7.a.k(view, i);
                                                                                                                    if (textView != null) {
                                                                                                                        i = j.title_text;
                                                                                                                        TextView textView2 = (TextView) z7.a.k(view, i);
                                                                                                                        if (textView2 != null) {
                                                                                                                            i = j.top_btns_lay;
                                                                                                                            if (((LinearLayout) z7.a.k(view, i)) != null) {
                                                                                                                                return new e(linearLayout, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, linearLayout2, viewK, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11, linearLayout3, imageButton12, imageButton13, constraintLayout, imageButton14, frameLayout, frameLayout2, imageButton15, linearLayout4, textView, textView2);
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
}
