package com.hrisko.quotes.views.QuoteCreate;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hrisko.quotes.R;
import com.hrisko.quotes.models.Quote;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteCreateFragment extends Fragment implements QuoteCreateContracts.View{

    private QuoteCreateContracts.Presenter mPresenter;

    @BindView(R.id.et_author)
    EditText mAuthorEditText;

    @BindView(R.id.et_topic)
    EditText mTopicEditText;

    @BindView(R.id.et_quote)
    EditText mQuoteText;

    @BindView(R.id.loading)
    ProgressBar mProgressBar;


    private QuoteCreateContracts.Navigator mNavigator;

    @Inject
    public QuoteCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quote_create, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @OnClick(R.id.btn_save)
    public void onQuoteSaveClicked() {
        String authorsName = mAuthorEditText.getText().toString();
        String topic = mTopicEditText.getText().toString();
        String quoteText = mQuoteText.getText().toString();
        String urlImage = "https://cdn.pixabay.com/photo/2013/07/12/12/37/letter-146011_960_720.png";
        Quote quote = new Quote(authorsName, topic, quoteText, urlImage);
        //int b = 5;
        mPresenter.save(quote);
    }

    @Override
    public void setPresenter(QuoteCreateContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void navigateToHome() {
        mNavigator.navigateToHome();
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(getContext(), "Error: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideLoading() {
    mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
    mProgressBar.setVisibility(View.VISIBLE);
    }

//    @Override
//    public void showRequirementsMessage(String message) {
//        Toast.makeText(getContext(), message, Toast.LENGTH_LONG)
//        .show();
//    }

    public void setNavigator(QuoteCreateContracts.Navigator navigator) {
        mNavigator = navigator;
    }
}
