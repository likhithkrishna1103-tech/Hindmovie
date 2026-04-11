package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import app.cricfy.tv.activities.MainActivity;
import g.f;
import g.g;
import g.h;
import g.j;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import m2.e;
import o.a3;
import o.b3;
import o.c3;
import o.e3;
import o.j0;
import o.o;
import o.s2;
import o.t2;
import o.u2;
import o.v2;
import o.w2;
import o.x2;
import o.y1;
import o.y2;
import o.z1;
import o.z2;
import t0.m0;
import w4.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class SearchView extends y1 implements m.b {
    public static final a3 D0;
    public final t2 A0;
    public final t2 B0;
    public final WeakHashMap C0;
    public final SearchAutoComplete K;
    public final View L;
    public final View M;
    public final View N;
    public final ImageView O;
    public final ImageView P;
    public final ImageView Q;
    public final ImageView R;
    public final View S;
    public c3 T;
    public final Rect U;
    public final Rect V;
    public final int[] W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int[] f555a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final ImageView f556b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final Drawable f557c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final int f558d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final int f559e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Intent f560f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final Intent f561g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final CharSequence f562h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public y2 f563i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public View.OnFocusChangeListener f564j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public View.OnClickListener f565k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f566l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f567m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public y0.a f568n0;
    public boolean o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public CharSequence f569p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f570q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f571r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f572s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f573t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public String f574u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public CharSequence f575v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f576w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f577x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public SearchableInfo f578y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public Bundle f579z0;

    static {
        a3 a3Var = null;
        if (Build.VERSION.SDK_INT < 29) {
            a3 a3Var2 = new a3();
            a3Var2.f9178a = null;
            a3Var2.f9179b = null;
            a3Var2.f9180c = null;
            a3.a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                a3Var2.f9178a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                a3Var2.f9179b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                a3Var2.f9180c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            a3Var = a3Var2;
        }
        D0 = a3Var;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SearchView(Context context) {
        int i = g.a.searchViewStyle;
        super(context, null, i);
        this.U = new Rect();
        this.V = new Rect();
        this.W = new int[2];
        this.f555a0 = new int[2];
        this.A0 = new t2(this, 0);
        this.B0 = new t2(this, 1);
        this.C0 = new WeakHashMap();
        a aVar = new a(this);
        b bVar = new b(this);
        w2 w2Var = new w2(this);
        j0 j0Var = new j0(1, this);
        z1 z1Var = new z1(1, this);
        s2 s2Var = new s2(this, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, j.SearchView, i, 0);
        l7.a aVar2 = new l7.a(context, typedArrayObtainStyledAttributes);
        m0.m(this, context, j.SearchView, null, typedArrayObtainStyledAttributes, i);
        LayoutInflater.from(context).inflate(typedArrayObtainStyledAttributes.getResourceId(j.SearchView_layout, g.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(f.search_src_text);
        this.K = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.L = findViewById(f.search_edit_frame);
        View viewFindViewById = findViewById(f.search_plate);
        this.M = viewFindViewById;
        View viewFindViewById2 = findViewById(f.submit_area);
        this.N = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(f.search_button);
        this.O = imageView;
        ImageView imageView2 = (ImageView) findViewById(f.search_go_btn);
        this.P = imageView2;
        ImageView imageView3 = (ImageView) findViewById(f.search_close_btn);
        this.Q = imageView3;
        ImageView imageView4 = (ImageView) findViewById(f.search_voice_btn);
        this.R = imageView4;
        ImageView imageView5 = (ImageView) findViewById(f.search_mag_icon);
        this.f556b0 = imageView5;
        viewFindViewById.setBackground(aVar2.u(j.SearchView_queryBackground));
        viewFindViewById2.setBackground(aVar2.u(j.SearchView_submitBackground));
        imageView.setImageDrawable(aVar2.u(j.SearchView_searchIcon));
        imageView2.setImageDrawable(aVar2.u(j.SearchView_goIcon));
        imageView3.setImageDrawable(aVar2.u(j.SearchView_closeIcon));
        imageView4.setImageDrawable(aVar2.u(j.SearchView_voiceIcon));
        imageView5.setImageDrawable(aVar2.u(j.SearchView_searchIcon));
        this.f557c0 = aVar2.u(j.SearchView_searchHintIcon);
        v.t(imageView, getResources().getString(h.abc_searchview_description_search));
        this.f558d0 = typedArrayObtainStyledAttributes.getResourceId(j.SearchView_suggestionRowLayout, g.abc_search_dropdown_item_icons_2line);
        this.f559e0 = typedArrayObtainStyledAttributes.getResourceId(j.SearchView_commitIcon, 0);
        imageView.setOnClickListener(aVar);
        imageView3.setOnClickListener(aVar);
        imageView2.setOnClickListener(aVar);
        imageView4.setOnClickListener(aVar);
        searchAutoComplete.setOnClickListener(aVar);
        searchAutoComplete.addTextChangedListener(s2Var);
        searchAutoComplete.setOnEditorActionListener(w2Var);
        searchAutoComplete.setOnItemClickListener(j0Var);
        searchAutoComplete.setOnItemSelectedListener(z1Var);
        searchAutoComplete.setOnKeyListener(bVar);
        searchAutoComplete.setOnFocusChangeListener(new u2(this));
        setIconifiedByDefault(typedArrayObtainStyledAttributes.getBoolean(j.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.f562h0 = typedArrayObtainStyledAttributes.getText(j.SearchView_defaultQueryHint);
        this.f569p0 = typedArrayObtainStyledAttributes.getText(j.SearchView_queryHint);
        int i10 = typedArrayObtainStyledAttributes.getInt(j.SearchView_android_imeOptions, -1);
        if (i10 != -1) {
            setImeOptions(i10);
        }
        int i11 = typedArrayObtainStyledAttributes.getInt(j.SearchView_android_inputType, -1);
        if (i11 != -1) {
            setInputType(i11);
        }
        setFocusable(typedArrayObtainStyledAttributes.getBoolean(j.SearchView_android_focusable, true));
        aVar2.G();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f560f0 = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f561g0 = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.S = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new v2(0, this));
        }
        w(this.f566l0);
        t();
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(g.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(g.d.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.K;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.f571r0 = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.K;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f571r0 = false;
    }

    public int getImeOptions() {
        return this.K.getImeOptions();
    }

    public int getInputType() {
        return this.K.getInputType();
    }

    public int getMaxWidth() {
        return this.f572s0;
    }

    public CharSequence getQuery() {
        return this.K.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f569p0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f578y0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f562h0 : getContext().getText(this.f578y0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f559e0;
    }

    public int getSuggestionRowLayout() {
        return this.f558d0;
    }

    public y0.a getSuggestionsAdapter() {
        return this.f568n0;
    }

    public final Intent j(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f575v0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f579z0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f578y0.getSearchActivity());
        return intent;
    }

    public final Intent k(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f579z0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void l() {
        int i = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.K;
        if (i >= 29) {
            c.a(searchAutoComplete);
            return;
        }
        a3 a3Var = D0;
        a3Var.getClass();
        a3.a();
        Method method = a3Var.f9178a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        a3Var.getClass();
        a3.a();
        Method method2 = a3Var.f9179b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void m() {
        SearchAutoComplete searchAutoComplete = this.K;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.f566l0) {
            clearFocus();
            w(true);
        }
    }

    public final void n(int i) {
        int position;
        String strH;
        Cursor cursor = this.f568n0.f14545x;
        if (cursor != null && cursor.moveToPosition(i)) {
            Intent intentJ = null;
            try {
                int i10 = e3.S;
                String strH2 = e3.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (strH2 == null) {
                    strH2 = this.f578y0.getSuggestIntentAction();
                }
                if (strH2 == null) {
                    strH2 = "android.intent.action.SEARCH";
                }
                String strH3 = e3.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (strH3 == null) {
                    strH3 = this.f578y0.getSuggestIntentData();
                }
                if (strH3 != null && (strH = e3.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    strH3 = strH3 + "/" + Uri.encode(strH);
                }
                intentJ = j(strH2, strH3 == null ? null : Uri.parse(strH3), e3.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), e3.h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e9) {
                try {
                    position = cursor.getPosition();
                } catch (RuntimeException unused) {
                    position = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e9);
            }
            if (intentJ != null) {
                try {
                    getContext().startActivity(intentJ);
                } catch (RuntimeException e10) {
                    Log.e("SearchView", "Failed launch activity: " + intentJ, e10);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.K;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void o(int i) {
        Editable text = this.K.getText();
        Cursor cursor = this.f568n0.f14545x;
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i)) {
            setQuery(text);
            return;
        }
        String strC = this.f568n0.c(cursor);
        if (strC != null) {
            setQuery(strC);
        } else {
            setQuery(text);
        }
    }

    @Override // m.b
    public final void onActionViewCollapsed() {
        SearchAutoComplete searchAutoComplete = this.K;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.f575v0 = "";
        clearFocus();
        w(true);
        searchAutoComplete.setImeOptions(this.f577x0);
        this.f576w0 = false;
    }

    @Override // m.b
    public final void onActionViewExpanded() {
        if (this.f576w0) {
            return;
        }
        this.f576w0 = true;
        SearchAutoComplete searchAutoComplete = this.K;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.f577x0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.A0);
        post(this.B0);
        super.onDetachedFromWindow();
    }

    @Override // o.y1, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
        if (z10) {
            SearchAutoComplete searchAutoComplete = this.K;
            int[] iArr = this.W;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.f555a0;
            getLocationInWindow(iArr2);
            int i13 = iArr[1] - iArr2[1];
            int i14 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i14;
            int height = searchAutoComplete.getHeight() + i13;
            Rect rect = this.U;
            rect.set(i14, i13, width, height);
            int i15 = rect.left;
            int i16 = rect.right;
            int i17 = i12 - i10;
            Rect rect2 = this.V;
            rect2.set(i15, 0, i16, i17);
            c3 c3Var = this.T;
            if (c3Var == null) {
                c3 c3Var2 = new c3(searchAutoComplete, rect2, rect);
                this.T = c3Var2;
                setTouchDelegate(c3Var2);
            } else {
                c3Var.f9188b.set(rect2);
                Rect rect3 = c3Var.f9190d;
                rect3.set(rect2);
                int i18 = -c3Var.f9191e;
                rect3.inset(i18, i18);
                c3Var.f9189c.set(rect);
            }
        }
    }

    @Override // o.y1, android.view.View
    public final void onMeasure(int i, int i10) {
        int i11;
        if (this.f567m0) {
            super.onMeasure(i, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i12 = this.f572s0;
            size = i12 > 0 ? Math.min(i12, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f572s0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i11 = this.f572s0) > 0) {
            size = Math.min(i11, size);
        }
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b3)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b3 b3Var = (b3) parcelable;
        super.onRestoreInstanceState(b3Var.f112v);
        w(b3Var.f9184x);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b3 b3Var = new b3(super.onSaveInstanceState());
        b3Var.f9184x = this.f567m0;
        return b3Var;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        post(this.A0);
    }

    public final void p(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public final void q() {
        SearchAutoComplete searchAutoComplete = this.K;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        y2 y2Var = this.f563i0;
        if (y2Var != null) {
            MainActivity.w((MainActivity) ((e) y2Var).f8050v, text.toString());
            return;
        }
        if (this.f578y0 != null) {
            getContext().startActivity(j("android.intent.action.SEARCH", null, null, text.toString()));
        }
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void r() {
        boolean zIsEmpty = TextUtils.isEmpty(this.K.getText());
        int i = (!zIsEmpty || (this.f566l0 && !this.f576w0)) ? 0 : 8;
        ImageView imageView = this.Q;
        imageView.setVisibility(i);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, Rect rect) {
        if (this.f571r0 || !isFocusable()) {
            return false;
        }
        if (this.f567m0) {
            return super.requestFocus(i, rect);
        }
        boolean zRequestFocus = this.K.requestFocus(i, rect);
        if (zRequestFocus) {
            w(false);
        }
        return zRequestFocus;
    }

    public final void s() {
        int[] iArr = this.K.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.M.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.N.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public void setAppSearchData(Bundle bundle) {
        this.f579z0 = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            m();
            return;
        }
        w(false);
        SearchAutoComplete searchAutoComplete = this.K;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f565k0;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.f566l0 == z10) {
            return;
        }
        this.f566l0 = z10;
        w(z10);
        t();
    }

    public void setImeOptions(int i) {
        this.K.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.K.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f572s0 = i;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f564j0 = onFocusChangeListener;
    }

    public void setOnQueryTextListener(y2 y2Var) {
        this.f563i0 = y2Var;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f565k0 = onClickListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f569p0 = charSequence;
        t();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        this.f570q0 = z10;
        y0.a aVar = this.f568n0;
        if (aVar instanceof e3) {
            ((e3) aVar).K = z10 ? 2 : 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSearchableInfo(android.app.SearchableInfo r7) {
        /*
            r6 = this;
            r6.f578y0 = r7
            r0 = 0
            r1 = 1
            androidx.appcompat.widget.SearchView$SearchAutoComplete r2 = r6.K
            if (r7 == 0) goto L65
            int r7 = r7.getSuggestThreshold()
            r2.setThreshold(r7)
            android.app.SearchableInfo r7 = r6.f578y0
            int r7 = r7.getImeOptions()
            r2.setImeOptions(r7)
            android.app.SearchableInfo r7 = r6.f578y0
            int r7 = r7.getInputType()
            r3 = r7 & 15
            if (r3 != r1) goto L31
            r3 = -65537(0xfffffffffffeffff, float:NaN)
            r7 = r7 & r3
            android.app.SearchableInfo r3 = r6.f578y0
            java.lang.String r3 = r3.getSuggestAuthority()
            if (r3 == 0) goto L31
            r3 = 589824(0x90000, float:8.2652E-40)
            r7 = r7 | r3
        L31:
            r2.setInputType(r7)
            y0.a r7 = r6.f568n0
            if (r7 == 0) goto L3b
            r7.b(r0)
        L3b:
            android.app.SearchableInfo r7 = r6.f578y0
            java.lang.String r7 = r7.getSuggestAuthority()
            if (r7 == 0) goto L62
            o.e3 r7 = new o.e3
            android.content.Context r3 = r6.getContext()
            android.app.SearchableInfo r4 = r6.f578y0
            java.util.WeakHashMap r5 = r6.C0
            r7.<init>(r3, r6, r4, r5)
            r6.f568n0 = r7
            r2.setAdapter(r7)
            y0.a r7 = r6.f568n0
            o.e3 r7 = (o.e3) r7
            boolean r3 = r6.f570q0
            if (r3 == 0) goto L5f
            r3 = 2
            goto L60
        L5f:
            r3 = r1
        L60:
            r7.K = r3
        L62:
            r6.t()
        L65:
            android.app.SearchableInfo r7 = r6.f578y0
            r3 = 0
            if (r7 == 0) goto L98
            boolean r7 = r7.getVoiceSearchEnabled()
            if (r7 == 0) goto L98
            android.app.SearchableInfo r7 = r6.f578y0
            boolean r7 = r7.getVoiceSearchLaunchWebSearch()
            if (r7 == 0) goto L7b
            android.content.Intent r0 = r6.f560f0
            goto L85
        L7b:
            android.app.SearchableInfo r7 = r6.f578y0
            boolean r7 = r7.getVoiceSearchLaunchRecognizer()
            if (r7 == 0) goto L85
            android.content.Intent r0 = r6.f561g0
        L85:
            if (r0 == 0) goto L98
            android.content.Context r7 = r6.getContext()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            r4 = 65536(0x10000, float:9.1835E-41)
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r0, r4)
            if (r7 == 0) goto L98
            goto L99
        L98:
            r1 = r3
        L99:
            r6.f573t0 = r1
            if (r1 == 0) goto La2
            java.lang.String r7 = "nm"
            r2.setPrivateImeOptions(r7)
        La2:
            boolean r7 = r6.f567m0
            r6.w(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.o0 = z10;
        w(this.f567m0);
    }

    public void setSuggestionsAdapter(y0.a aVar) {
        this.f568n0 = aVar;
        this.K.setAdapter(aVar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void t() {
        CharSequence queryHint = getQueryHint();
        CharSequence charSequence = queryHint;
        if (queryHint == null) {
            charSequence = "";
        }
        boolean z10 = this.f566l0;
        SearchAutoComplete searchAutoComplete = this.K;
        CharSequence charSequence2 = charSequence;
        if (z10) {
            Drawable drawable = this.f557c0;
            charSequence2 = charSequence;
            if (drawable != null) {
                int textSize = (int) (((double) searchAutoComplete.getTextSize()) * 1.25d);
                drawable.setBounds(0, 0, textSize, textSize);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
                spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
                spannableStringBuilder.append(charSequence);
                charSequence2 = spannableStringBuilder;
            }
        }
        searchAutoComplete.setHint(charSequence2);
    }

    public final void u() {
        this.N.setVisibility(((this.o0 || this.f573t0) && !this.f567m0 && (this.P.getVisibility() == 0 || this.R.getVisibility() == 0)) ? 0 : 8);
    }

    public final void v(boolean z10) {
        boolean z11 = this.o0;
        this.P.setVisibility((!z11 || !(z11 || this.f573t0) || this.f567m0 || !hasFocus() || (!z10 && this.f573t0)) ? 8 : 0);
    }

    public final void w(boolean z10) {
        this.f567m0 = z10;
        int i = 8;
        int i10 = z10 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.K.getText());
        this.O.setVisibility(i10);
        v(!zIsEmpty);
        this.L.setVisibility(z10 ? 8 : 0);
        ImageView imageView = this.f556b0;
        imageView.setVisibility((imageView.getDrawable() == null || this.f566l0) ? 8 : 0);
        r();
        if (this.f573t0 && !this.f567m0 && zIsEmpty) {
            this.P.setVisibility(8);
            i = 0;
        }
        this.R.setVisibility(i);
        u();
    }

    /* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
    public static class SearchAutoComplete extends o {
        public SearchView A;
        public boolean B;
        public final d C;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f580z;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet, g.a.autoCompleteTextViewStyle);
            this.C = new d(this);
            this.f580z = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i10 = configuration.screenHeightDp;
            if (i >= 960 && i10 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i10 < 480) ? 160 : 192;
            }
            return 192;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            a3 a3Var = SearchView.D0;
            a3Var.getClass();
            a3.a();
            Method method = a3Var.f9180c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.f580z <= 0 || super.enoughToFilter();
        }

        @Override // o.o, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.B) {
                d dVar = this.C;
                removeCallbacks(dVar);
                post(dVar);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z10, int i, Rect rect) {
            super.onFocusChanged(z10, i, rect);
            SearchView searchView = this.A;
            searchView.w(searchView.f567m0);
            searchView.post(searchView.A0);
            if (searchView.K.hasFocus()) {
                searchView.l();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.A.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z10) {
            super.onWindowFocusChanged(z10);
            if (z10 && this.A.hasFocus() && getVisibility() == 0) {
                this.B = true;
                Context context = getContext();
                a3 a3Var = SearchView.D0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        public void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            d dVar = this.C;
            if (!z10) {
                this.B = false;
                removeCallbacks(dVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.B = true;
                    return;
                }
                this.B = false;
                removeCallbacks(dVar);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.A = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f580z = i;
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }
    }

    public void setOnCloseListener(x2 x2Var) {
    }

    public void setOnSuggestionListener(z2 z2Var) {
    }
}
