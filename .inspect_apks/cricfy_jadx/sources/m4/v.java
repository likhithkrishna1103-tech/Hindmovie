package m4;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.PlayerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f8269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f8270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f8271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f8272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f8273e;
    public final ViewGroup f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f8274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f8275h;
    public final ViewGroup i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f8276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f8277k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AnimatorSet f8278l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AnimatorSet f8279m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AnimatorSet f8280n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AnimatorSet f8281o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AnimatorSet f8282p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ValueAnimator f8283q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ValueAnimator f8284r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final r f8285s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final r f8286t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final r f8288v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d f8290x;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final r f8287u = new r(this, 4);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final r f8289w = new r(this, 6);
    public boolean C = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f8292z = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList f8291y = new ArrayList();

    public v(q qVar) {
        this.f8269a = qVar;
        final int i = 0;
        this.f8285s = new r(this, i);
        final int i10 = 3;
        this.f8286t = new r(this, i10);
        int i11 = 5;
        this.f8288v = new r(this, i11);
        final int i12 = 1;
        this.f8290x = new d(i12, this);
        this.f8270b = qVar.findViewById(f0.exo_controls_background);
        this.f8271c = (ViewGroup) qVar.findViewById(f0.exo_center_controls);
        this.f8273e = (ViewGroup) qVar.findViewById(f0.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) qVar.findViewById(f0.exo_bottom_bar);
        this.f8272d = viewGroup;
        this.i = (ViewGroup) qVar.findViewById(f0.exo_time);
        View viewFindViewById = qVar.findViewById(f0.exo_progress);
        this.f8276j = viewFindViewById;
        this.f = (ViewGroup) qVar.findViewById(f0.exo_basic_controls);
        this.f8274g = (ViewGroup) qVar.findViewById(f0.exo_extra_controls);
        this.f8275h = (ViewGroup) qVar.findViewById(f0.exo_extra_controls_scroll_view);
        View viewFindViewById2 = qVar.findViewById(f0.exo_overflow_show);
        this.f8277k = viewFindViewById2;
        View viewFindViewById3 = qVar.findViewById(f0.exo_overflow_hide);
        if (viewFindViewById2 != null && viewFindViewById3 != null) {
            viewFindViewById2.setOnClickListener(new com.google.android.material.datepicker.n(i11, this));
            viewFindViewById3.setOnClickListener(new com.google.android.material.datepicker.n(i11, this));
        }
        final int i13 = 2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: m4.s

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v f8261b;

            {
                this.f8261b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        v vVar = this.f8261b;
                        vVar.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = vVar.f8270b;
                        if (view != null) {
                            view.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup2 = vVar.f8271c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup3 = vVar.f8273e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(fFloatValue);
                        }
                        break;
                    case 1:
                        v vVar2 = this.f8261b;
                        vVar2.getClass();
                        vVar2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        v vVar3 = this.f8261b;
                        vVar3.getClass();
                        vVar3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        v vVar4 = this.f8261b;
                        vVar4.getClass();
                        float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = vVar4.f8270b;
                        if (view2 != null) {
                            view2.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup4 = vVar4.f8271c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup5 = vVar4.f8273e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(fFloatValue2);
                        }
                        break;
                }
            }
        });
        valueAnimatorOfFloat.addListener(new t(this, i));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: m4.s

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v f8261b;

            {
                this.f8261b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        v vVar = this.f8261b;
                        vVar.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = vVar.f8270b;
                        if (view != null) {
                            view.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup2 = vVar.f8271c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup3 = vVar.f8273e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(fFloatValue);
                        }
                        break;
                    case 1:
                        v vVar2 = this.f8261b;
                        vVar2.getClass();
                        vVar2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        v vVar3 = this.f8261b;
                        vVar3.getClass();
                        vVar3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        v vVar4 = this.f8261b;
                        vVar4.getClass();
                        float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = vVar4.f8270b;
                        if (view2 != null) {
                            view2.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup4 = vVar4.f8271c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup5 = vVar4.f8273e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(fFloatValue2);
                        }
                        break;
                }
            }
        });
        valueAnimatorOfFloat2.addListener(new t(this, i12));
        Resources resources = qVar.getResources();
        float dimension = resources.getDimension(c0.exo_styled_bottom_bar_height) - resources.getDimension(c0.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(c0.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f8278l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new u(this, qVar, i));
        animatorSet.play(valueAnimatorOfFloat).with(d(viewFindViewById, 0.0f, dimension)).with(d(viewGroup, 0.0f, dimension));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f8279m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new u(this, qVar, i12));
        animatorSet2.play(d(viewFindViewById, dimension, dimension2)).with(d(viewGroup, dimension, dimension2));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f8280n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new u(this, qVar, i13));
        animatorSet3.play(valueAnimatorOfFloat).with(d(viewFindViewById, 0.0f, dimension2)).with(d(viewGroup, 0.0f, dimension2));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f8281o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new t(this, i13));
        animatorSet4.play(valueAnimatorOfFloat2).with(d(viewFindViewById, dimension, 0.0f)).with(d(viewGroup, dimension, 0.0f));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f8282p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new t(this, i10));
        animatorSet5.play(valueAnimatorOfFloat2).with(d(viewFindViewById, dimension2, 0.0f)).with(d(viewGroup, dimension2, 0.0f));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f8283q = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: m4.s

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v f8261b;

            {
                this.f8261b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i12) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        v vVar = this.f8261b;
                        vVar.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = vVar.f8270b;
                        if (view != null) {
                            view.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup2 = vVar.f8271c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup3 = vVar.f8273e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(fFloatValue);
                        }
                        break;
                    case 1:
                        v vVar2 = this.f8261b;
                        vVar2.getClass();
                        vVar2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        v vVar3 = this.f8261b;
                        vVar3.getClass();
                        vVar3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        v vVar4 = this.f8261b;
                        vVar4.getClass();
                        float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = vVar4.f8270b;
                        if (view2 != null) {
                            view2.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup4 = vVar4.f8271c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup5 = vVar4.f8273e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(fFloatValue2);
                        }
                        break;
                }
            }
        });
        valueAnimatorOfFloat3.addListener(new t(this, 4));
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f8284r = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(250L);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: m4.s

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v f8261b;

            {
                this.f8261b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i13) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        v vVar = this.f8261b;
                        vVar.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view = vVar.f8270b;
                        if (view != null) {
                            view.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup2 = vVar.f8271c;
                        if (viewGroup2 != null) {
                            viewGroup2.setAlpha(fFloatValue);
                        }
                        ViewGroup viewGroup3 = vVar.f8273e;
                        if (viewGroup3 != null) {
                            viewGroup3.setAlpha(fFloatValue);
                        }
                        break;
                    case 1:
                        v vVar2 = this.f8261b;
                        vVar2.getClass();
                        vVar2.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    case 2:
                        v vVar3 = this.f8261b;
                        vVar3.getClass();
                        vVar3.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        v vVar4 = this.f8261b;
                        vVar4.getClass();
                        float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        View view2 = vVar4.f8270b;
                        if (view2 != null) {
                            view2.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup4 = vVar4.f8271c;
                        if (viewGroup4 != null) {
                            viewGroup4.setAlpha(fFloatValue2);
                        }
                        ViewGroup viewGroup5 = vVar4.f8273e;
                        if (viewGroup5 != null) {
                            viewGroup5.setAlpha(fFloatValue2);
                        }
                        break;
                }
            }
        });
        valueAnimatorOfFloat4.addListener(new t(this, 5));
    }

    public static int c(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + width;
    }

    public static ObjectAnimator d(View view, float f, float f10) {
        return ObjectAnimator.ofFloat(view, "translationY", f, f10);
    }

    public static boolean j(View view) {
        int id2 = view.getId();
        return id2 == f0.exo_bottom_bar || id2 == f0.exo_prev || id2 == f0.exo_next || id2 == f0.exo_rew || id2 == f0.exo_rew_with_amount || id2 == f0.exo_ffwd || id2 == f0.exo_ffwd_with_amount;
    }

    public final void a(float f) {
        ViewGroup viewGroup = this.f8275h;
        if (viewGroup != null) {
            viewGroup.setTranslationX((int) ((1.0f - f) * viewGroup.getWidth()));
        }
        ViewGroup viewGroup2 = this.i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f);
        }
        ViewGroup viewGroup3 = this.f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f);
        }
    }

    public final boolean b(View view) {
        return view != null && this.f8291y.contains(view);
    }

    public final void e(Runnable runnable, long j4) {
        if (j4 >= 0) {
            this.f8269a.postDelayed(runnable, j4);
        }
    }

    public final void f() {
        r rVar = this.f8289w;
        q qVar = this.f8269a;
        qVar.removeCallbacks(rVar);
        qVar.removeCallbacks(this.f8286t);
        qVar.removeCallbacks(this.f8288v);
        qVar.removeCallbacks(this.f8287u);
    }

    public final void g() {
        if (this.f8292z == 3) {
            return;
        }
        f();
        int showTimeoutMs = this.f8269a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                e(this.f8289w, showTimeoutMs);
            } else if (this.f8292z == 1) {
                e(this.f8287u, 2000L);
            } else {
                e(this.f8288v, showTimeoutMs);
            }
        }
    }

    public final void h(View view, boolean z10) {
        if (view == null) {
            return;
        }
        ArrayList arrayList = this.f8291y;
        if (!z10) {
            view.setVisibility(8);
            arrayList.remove(view);
            return;
        }
        if (this.A && j(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        arrayList.add(view);
    }

    public final void i(int i) {
        int i10 = this.f8292z;
        this.f8292z = i;
        q qVar = this.f8269a;
        if (i == 2) {
            qVar.setVisibility(8);
        } else if (i10 == 2) {
            qVar.setVisibility(0);
        }
        if (i10 != i) {
            for (p pVar : qVar.f8254y) {
                int visibility = qVar.getVisibility();
                PlayerView playerView = ((x) pVar).f8301x;
                playerView.k();
                y yVar = playerView.J;
                if (yVar != null) {
                    q5.g gVar = (q5.g) ((kf.i) yVar).f7483w;
                    if (!gVar.L && !gVar.M) {
                        gVar.J = visibility == 0;
                    }
                }
            }
        }
    }

    public final void k() {
        if (!this.C) {
            i(0);
            g();
            return;
        }
        int i = this.f8292z;
        if (i == 1) {
            this.f8281o.start();
        } else if (i == 2) {
            this.f8282p.start();
        } else if (i == 3) {
            this.B = true;
        } else if (i == 4) {
            return;
        }
        g();
    }
}
