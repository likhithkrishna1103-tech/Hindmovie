package u5;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.ui.DefaultTimeBar;
import q5.k;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f12243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageButton f12244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f12245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageButton f12246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f12247e;
    public final ImageButton f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageButton f12248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageButton f12249h;
    public final ImageButton i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageButton f12250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageButton f12251k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageButton f12252l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final FrameLayout f12253m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageButton f12254n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ImageButton f12255o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LinearLayout f12256p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LinearLayout f12257q;

    public d(ImageView imageView, ImageButton imageButton, LinearLayout linearLayout, ImageButton imageButton2, View view, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9, FrameLayout frameLayout, ImageButton imageButton10, ImageButton imageButton11, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        this.f12243a = imageView;
        this.f12244b = imageButton;
        this.f12245c = linearLayout;
        this.f12246d = imageButton2;
        this.f12247e = view;
        this.f = imageButton3;
        this.f12248g = imageButton4;
        this.f12249h = imageButton5;
        this.i = imageButton6;
        this.f12250j = imageButton7;
        this.f12251k = imageButton8;
        this.f12252l = imageButton9;
        this.f12253m = frameLayout;
        this.f12254n = imageButton10;
        this.f12255o = imageButton11;
        this.f12256p = linearLayout2;
        this.f12257q = linearLayout3;
    }

    public static d a(View view) {
        View viewL;
        int i = k.adjust_btn;
        ImageView imageView = (ImageView) android.support.v4.media.session.b.l(view, i);
        if (imageView != null) {
            i = k.back_btn;
            ImageButton imageButton = (ImageButton) android.support.v4.media.session.b.l(view, i);
            if (imageButton != null) {
                i = k.bottom_controller;
                LinearLayout linearLayout = (LinearLayout) android.support.v4.media.session.b.l(view, i);
                if (linearLayout != null) {
                    i = k.close_btn;
                    ImageButton imageButton2 = (ImageButton) android.support.v4.media.session.b.l(view, i);
                    if (imageButton2 != null) {
                        i = k.custom_controls;
                        if (((LinearLayout) android.support.v4.media.session.b.l(view, i)) != null && (viewL = android.support.v4.media.session.b.l(view, (i = k.exo_controls_background))) != null) {
                            i = k.exo_duration;
                            if (((TextView) android.support.v4.media.session.b.l(view, i)) != null) {
                                i = k.exo_exo_rew_container;
                                if (((FrameLayout) android.support.v4.media.session.b.l(view, i)) != null) {
                                    i = k.exo_ffwd;
                                    if (((ImageButton) android.support.v4.media.session.b.l(view, i)) != null) {
                                        i = k.exo_ffwd_container;
                                        if (((FrameLayout) android.support.v4.media.session.b.l(view, i)) != null) {
                                            i = k.exo_fullscreen_btn;
                                            ImageButton imageButton3 = (ImageButton) android.support.v4.media.session.b.l(view, i);
                                            if (imageButton3 != null) {
                                                i = k.exo_lock;
                                                ImageButton imageButton4 = (ImageButton) android.support.v4.media.session.b.l(view, i);
                                                if (imageButton4 != null) {
                                                    i = k.exo_mute;
                                                    ImageButton imageButton5 = (ImageButton) android.support.v4.media.session.b.l(view, i);
                                                    if (imageButton5 != null) {
                                                        i = k.exo_pip;
                                                        ImageButton imageButton6 = (ImageButton) android.support.v4.media.session.b.l(view, i);
                                                        if (imageButton6 != null) {
                                                            i = k.exo_position;
                                                            if (((TextView) android.support.v4.media.session.b.l(view, i)) != null) {
                                                                i = k.exo_progress;
                                                                if (((DefaultTimeBar) android.support.v4.media.session.b.l(view, i)) != null) {
                                                                    i = k.exo_rew;
                                                                    if (((ImageButton) android.support.v4.media.session.b.l(view, i)) != null) {
                                                                        i = k.exo_settings;
                                                                        ImageButton imageButton7 = (ImageButton) android.support.v4.media.session.b.l(view, i);
                                                                        if (imageButton7 != null) {
                                                                            i = k.exo_unlock;
                                                                            ImageButton imageButton8 = (ImageButton) android.support.v4.media.session.b.l(view, i);
                                                                            if (imageButton8 != null) {
                                                                                i = k.floating_fullscreen_btn;
                                                                                ImageButton imageButton9 = (ImageButton) android.support.v4.media.session.b.l(view, i);
                                                                                if (imageButton9 != null) {
                                                                                    i = k.left_ly;
                                                                                    if (((LinearLayout) android.support.v4.media.session.b.l(view, i)) != null) {
                                                                                        i = k.links_container;
                                                                                        FrameLayout frameLayout = (FrameLayout) android.support.v4.media.session.b.l(view, i);
                                                                                        if (frameLayout != null) {
                                                                                            i = k.pause_btn;
                                                                                            ImageButton imageButton10 = (ImageButton) android.support.v4.media.session.b.l(view, i);
                                                                                            if (imageButton10 != null) {
                                                                                                i = k.play_btn;
                                                                                                ImageButton imageButton11 = (ImageButton) android.support.v4.media.session.b.l(view, i);
                                                                                                if (imageButton11 != null) {
                                                                                                    i = k.right_ly;
                                                                                                    if (((LinearLayout) android.support.v4.media.session.b.l(view, i)) != null) {
                                                                                                        i = k.timer_bar_ly;
                                                                                                        LinearLayout linearLayout2 = (LinearLayout) android.support.v4.media.session.b.l(view, i);
                                                                                                        if (linearLayout2 != null) {
                                                                                                            i = k.top_bar;
                                                                                                            LinearLayout linearLayout3 = (LinearLayout) android.support.v4.media.session.b.l(view, i);
                                                                                                            if (linearLayout3 != null) {
                                                                                                                return new d(imageView, imageButton, linearLayout, imageButton2, viewL, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, frameLayout, imageButton10, imageButton11, linearLayout2, linearLayout3);
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
