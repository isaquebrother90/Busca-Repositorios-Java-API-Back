/*
 * package com.buscarepositorio.buscador.Controllers;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.junit.jupiter.api.extension.ExtendWith; import
 * org.mockito.InjectMocks; import static
 * com.buscarepositorio.buscador.Utils.JsonConvertionUtils.asJsonString; import
 * static org.mockito.Mockito.doThrow; import static org.mockito.Mockito.when;
 * import static org.hamcrest.core.Is.is; import static
 * org.mockito.Mockito.doNothing; import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * import org.mockito.Mock; import org.springframework.http.MediaType; import
 * org.mockito.junit.jupiter.MockitoExtension; import
 * org.springframework.data.web.PageableHandlerMethodArgumentResolver; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * org.springframework.test.web.servlet.setup.MockMvcBuilders; import
 * org.springframework.web.servlet.view.json.MappingJackson2JsonView;
 * 
 * import com.buscarepositorio.buscador.Builders.RepositorioEntityBuilder;
 * import com.buscarepositorio.buscador.entities.RepositorioEntity; import
 * com.buscarepositorio.buscador.resources.BaseController; import
 * com.buscarepositorio.buscador.resources.BaseService;
 * 
 * 
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
 * 
 * @ExtendWith(MockitoExtension.class) public class BaseControllerTest {
 * 
 * private static final String REPO_API_URL_PATH = "/repositorios";
 * 
 * private MockMvc mockMvc;
 * 
 * @Mock private BaseService baseService;
 * 
 * @InjectMocks private BaseController baseController;
 * 
 * @BeforeEach void setUp() { mockMvc =
 * MockMvcBuilders.standaloneSetup(baseController)
 * .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
 * .setViewResolvers((s, locale) -> new MappingJackson2JsonView()) .build(); }
 * 
 * @Test void whenGETIsCalledWithValidNameThenOkStatusIsReturned() throws
 * Exception { // given RepositorioEntity repositorioEntity =
 * RepositorioEntityBuilder.builder().build().toRepositorioEntity();
 * 
 * //when when(baseService.findByName(repositorioEntity.getName())).thenReturn(
 * repositorioEntity);
 * 
 * // then mockMvc.perform(MockMvcRequestBuilders.get(REPO_API_URL_PATH + "/" +
 * repositorioEntity.getName()) .contentType(MediaType.APPLICATION_JSON))
 * .andExpect(status().isOk()) .andExpect(jsonPath("$.name",
 * is(repositorioEntity.getName()))) //.andExpect(jsonPath("$.brand",
 * is(beerDTO.getBrand()))) .andExpect(jsonPath("$.type",
 * is(repositorioEntity.getType().toString()))); }
 * 
 * 
 * }
 */